package czechowski.treeswebappbackend.service;

import czechowski.treeswebappbackend.dto.MagazynDTO;
import czechowski.treeswebappbackend.dto.UpdateMagazynRequest;
import czechowski.treeswebappbackend.model.Gatunek;
import czechowski.treeswebappbackend.model.Magazyn;
import czechowski.treeswebappbackend.model.Stoisko;
import czechowski.treeswebappbackend.model.Wielkosc;
import czechowski.treeswebappbackend.repository.GatunekRepository;
import czechowski.treeswebappbackend.repository.MagazynRepository;
import czechowski.treeswebappbackend.repository.StoiskoRepository;
import czechowski.treeswebappbackend.repository.WielkoscRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class MagazynService {

    private final MagazynRepository magazynRepository;
    private final StoiskoRepository stoiskoRepository;
    private final GatunekRepository gatunekRepository;
    private final WielkoscRepository wielkoscRepository;

    public List<MagazynDTO> findAllMagazynByStoiskoId(Integer stoiskoId) {
        Stoisko stoisko = stoiskoRepository.findById(stoiskoId)
                .orElseThrow(() -> new RuntimeException("Stoisko nie znalezione"));

        List<Magazyn> magazyny = magazynRepository.findByStoiskoid(stoisko);

        return magazyny.stream()
                .map(magazyn -> new MagazynDTO(
                        magazyn.getId(),
                        magazyn.getGatunekid().getId(),
                        magazyn.getWielkoscid().getId(),
                        magazyn.getStoiskoid().getId(),
                        magazyn.getIlosc()
                ))
                .collect(Collectors.toList());
    }

    public MagazynDTO updateMagazyn(UpdateMagazynRequest request) {
        Stoisko stoisko = stoiskoRepository.findById(request.stoiskoId())
                .orElseThrow(() -> new RuntimeException("Stoisko nie znalezione"));

        Gatunek gatunek = gatunekRepository.findById(request.gatunekId())
                .orElseThrow(() -> new RuntimeException("Gatunek nie znaleziony"));

        Wielkosc wielkosc = wielkoscRepository.findById(request.wielkoscId())
                .orElseThrow(() -> new RuntimeException("Wielkość nie znaleziona"));


        Magazyn magazyn = magazynRepository
                .findByStoiskoidAndGatunekidAndWielkoscid(stoisko, gatunek, wielkosc)
                .orElse(Magazyn.builder()
                        .stoiskoid(stoisko)
                        .gatunekid(gatunek)
                        .wielkoscid(wielkosc)
                        .ilosc(0)
                        .build());

        magazyn.setIlosc(request.ilosc());
        Magazyn savedMagazyn = magazynRepository.save(magazyn);

        return new MagazynDTO(
                savedMagazyn.getId(),
                savedMagazyn.getGatunekid().getId(),
                savedMagazyn.getWielkoscid().getId(),
                savedMagazyn.getStoiskoid().getId(),
                savedMagazyn.getIlosc()
        );
    }

    public MagazynDTO addToMagazyn(UpdateMagazynRequest request) {
        Stoisko stoisko = stoiskoRepository.findById(request.stoiskoId())
                .orElseThrow(() -> new RuntimeException("Stoisko nie znalezione"));

        Gatunek gatunek = gatunekRepository.findById(request.gatunekId())
                .orElseThrow(() -> new RuntimeException("Gatunek nie znaleziony"));

        Wielkosc wielkosc = wielkoscRepository.findById(request.wielkoscId())
                .orElseThrow(() -> new RuntimeException("Wielkość nie znaleziona"));

        Magazyn magazyn = magazynRepository
                .findByStoiskoidAndGatunekidAndWielkoscid(stoisko, gatunek, wielkosc)
                .orElse(Magazyn.builder()
                        .stoiskoid(stoisko)
                        .gatunekid(gatunek)
                        .wielkoscid(wielkosc)
                        .ilosc(0)
                        .build());

        magazyn.setIlosc(magazyn.getIlosc() + request.ilosc());
        Magazyn savedMagazyn = magazynRepository.save(magazyn);

        return new MagazynDTO(
                savedMagazyn.getId(),
                savedMagazyn.getGatunekid().getId(),
                savedMagazyn.getWielkoscid().getId(),
                savedMagazyn.getStoiskoid().getId(),
                savedMagazyn.getIlosc()
        );
    }

    public MagazynDTO subtractFromMagazyn(UpdateMagazynRequest request) {
        Stoisko stoisko = stoiskoRepository.findById(request.stoiskoId())
                .orElseThrow(() -> new RuntimeException("Stoisko nie znalezione"));

        Gatunek gatunek = gatunekRepository.findById(request.gatunekId())
                .orElseThrow(() -> new RuntimeException("Gatunek nie znaleziony"));

        Wielkosc wielkosc = wielkoscRepository.findById(request.wielkoscId())
                .orElseThrow(() -> new RuntimeException("Wielkość nie znaleziona"));

        Magazyn magazyn = magazynRepository
                .findByStoiskoidAndGatunekidAndWielkoscid(stoisko, gatunek, wielkosc)
                .orElseThrow(() -> new RuntimeException("Pozycja magazynowa nie znaleziona"));

        int nowaIlosc = magazyn.getIlosc() - request.ilosc();
        if (nowaIlosc < 0) {
            throw new RuntimeException("Nie można odjąć więcej niż jest w magazynie");
        }

        magazyn.setIlosc(nowaIlosc);
        Magazyn savedMagazyn = magazynRepository.save(magazyn);

        return new MagazynDTO(
                savedMagazyn.getId(),
                savedMagazyn.getGatunekid().getId(),
                savedMagazyn.getWielkoscid().getId(),
                savedMagazyn.getStoiskoid().getId(),
                savedMagazyn.getIlosc()
        );
    }
}

