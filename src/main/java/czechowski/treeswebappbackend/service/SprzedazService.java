package czechowski.treeswebappbackend.service;


import czechowski.treeswebappbackend.dto.SprzedazDTO;
import czechowski.treeswebappbackend.model.Stoisko;
import czechowski.treeswebappbackend.model.Uzytkownicy;
import czechowski.treeswebappbackend.repository.SprzedazRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SprzedazService {

    @Autowired
    private SprzedazRepository sprzedazRepository;

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
}




