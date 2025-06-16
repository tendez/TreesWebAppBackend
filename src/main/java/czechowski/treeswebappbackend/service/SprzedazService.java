package czechowski.treeswebappbackend.service;


import czechowski.treeswebappbackend.dto.CreateSprzedazRequest;
import czechowski.treeswebappbackend.dto.SprzedazDTO;
import czechowski.treeswebappbackend.dto.SprzedazDetailDTO;
import czechowski.treeswebappbackend.model.*;
import czechowski.treeswebappbackend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SprzedazService {

    @Autowired
    private SprzedazRepository sprzedazRepository;
    private final UzytkownicyRepository uzytkownicyRepository;
    private final StoiskoRepository stoiskoRepository;
    private final GatunekRepository gatunekRepository;
    private final WielkoscRepository wielkoscRepository;

    public SprzedazService(UzytkownicyRepository uzytkownicyRepository, StoiskoRepository stoiskoRepository, GatunekRepository gatunekRepository, WielkoscRepository wielkoscRepository) {
        this.uzytkownicyRepository = uzytkownicyRepository;
        this.stoiskoRepository = stoiskoRepository;
        this.gatunekRepository = gatunekRepository;
        this.wielkoscRepository = wielkoscRepository;
    }


    public List<SprzedazDTO> findSprzedazDTOsByStoiskoId(Stoisko stoisko) {
        return sprzedazRepository.findAllSprzedazByStoiskoID(stoisko)
                .stream()
                .map(sprzedaz -> new SprzedazDTO(
                        sprzedaz.getId(),
                        sprzedaz.getGatunekID().getId(),
                        sprzedaz.getWielkoscID().getId(),
                        sprzedaz.getStoiskoID().getId(),
                        sprzedaz.getUserID().getId(),
                        sprzedaz.getCena().intValue(),
                        sprzedaz.getDatasprzedazy().toString()))
                .toList();
    }

    public List<SprzedazDTO> findSprzedazDTOsByUserID(Uzytkownicy userID) {
        return sprzedazRepository.findAllByUserID(userID)
                .stream()
                .map(sprzedaz -> new SprzedazDTO(
                        sprzedaz.getId(),
                        sprzedaz.getGatunekID().getId(),
                        sprzedaz.getWielkoscID().getId(),
                        sprzedaz.getStoiskoID().getId(),
                        sprzedaz.getUserID().getId(),
                        sprzedaz.getCena().intValue(),
                        sprzedaz.getDatasprzedazy().toString()))
                .toList();
    }

    public List<SprzedazDTO> findSprzedazDTOsByUserIDAndDatasprzedazy(Uzytkownicy userID, String dataSprzedazy) {
        return sprzedazRepository.findAllByUserIDAndDatasprzedazy(userID, LocalDate.parse(dataSprzedazy))
                .stream()
                .map(sprzedaz -> new SprzedazDTO(sprzedaz.getId(),
                        sprzedaz.getGatunekID().getId(),
                        sprzedaz.getWielkoscID().getId(),
                        sprzedaz.getStoiskoID().getId(),
                        sprzedaz.getUserID().getId(),
                        sprzedaz.getCena().intValue(),
                        sprzedaz.getDatasprzedazy().toString()))
                .toList();
    }
    public SprzedazDTO createSprzedaz(CreateSprzedazRequest request, String userLogin) {

        Uzytkownicy user = uzytkownicyRepository.findByLogin(userLogin)
                .orElseThrow(() -> new RuntimeException("Użytkownik nie znaleziony"));


        Stoisko stoisko = stoiskoRepository.findById(request.stoiskoId())
                .orElseThrow(() -> new RuntimeException("Stoisko nie znalezione"));


        Gatunek gatunek = gatunekRepository.findById(request.gatunekId())
                .orElseThrow(() -> new RuntimeException("Gatunek nie znaleziony"));


        Wielkosc wielkosc = wielkoscRepository.findById(request.wielkoscId())
                .orElseThrow(() -> new RuntimeException("Wielkość nie znaleziona"));


        Sprzedaz sprzedaz = Sprzedaz.builder()
                .gatunekID(gatunek)
                .wielkoscID(wielkosc)
                .stoiskoID(stoisko)
                .userID(user)
                .cena(BigDecimal.valueOf(request.cena()))
                .datasprzedazy(LocalDate.now())
                .build();

        Sprzedaz savedSprzedaz = sprzedazRepository.save(sprzedaz);

        return new SprzedazDTO(
                savedSprzedaz.getId(),
                savedSprzedaz.getGatunekID().getId(),
                savedSprzedaz.getWielkoscID().getId(),
                savedSprzedaz.getStoiskoID().getId(),
                savedSprzedaz.getUserID().getId(),
                savedSprzedaz.getCena().intValue(),
                savedSprzedaz.getDatasprzedazy().toString()
        );
    }
    public List<SprzedazDetailDTO> findSprzedazDetailsById(Stoisko stoisko) {

        List<Sprzedaz> sprzedaze = sprzedazRepository.findByStoiskoID(stoisko);

        return sprzedaze.stream()
                .map(sprzedaz -> new SprzedazDetailDTO(
                        sprzedaz.getId(),
                        sprzedaz.getGatunekID().getNazwagatunku(),
                        sprzedaz.getWielkoscID().getOpiswielkosci(),
                        sprzedaz.getStoiskoID().getStoiskonazwa(),
                        sprzedaz.getUserID().getLogin(),

                        sprzedaz.getCena().intValue(),
                        sprzedaz.getDatasprzedazy().toString()
                ))
                .collect(Collectors.toList());
    }


    public List<SprzedazDetailDTO> findSprzedazDetailsByUserId(Uzytkownicy user) {

        List<Sprzedaz> sprzedaze = sprzedazRepository.findByUserID(user);

        return sprzedaze.stream()
                .map(sprzedaz -> new SprzedazDetailDTO(
                        sprzedaz.getId(),
                        sprzedaz.getGatunekID().getNazwagatunku(),
                        sprzedaz.getWielkoscID().getOpiswielkosci(),
                        sprzedaz.getStoiskoID().getStoiskonazwa(),
                        sprzedaz.getUserID().getLogin(),
                        sprzedaz.getCena().intValue(),
                        sprzedaz.getDatasprzedazy().toString()
                ))
                .collect(Collectors.toList());
    }
}