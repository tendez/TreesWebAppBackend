package czechowski.treeswebappbackend.service;

import czechowski.treeswebappbackend.dto.MagazynDTO;
import czechowski.treeswebappbackend.model.Stoisko;
import czechowski.treeswebappbackend.repository.MagazynRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagazynService {

    @Autowired
    private MagazynRepository magazynRepository;

    public List<MagazynDTO> findAllMagazyn(Stoisko stoiskoId) {
        return magazynRepository.findMagazynByStoiskoid(stoiskoId)
                .stream()
                .map(magazyn -> new MagazynDTO(
                        magazyn.getId(),
                        magazyn.getGatunekid().getId(),
                        magazyn.getWielkoscid().getId(),
                        magazyn.getStoiskoid().getId(),
                        magazyn.getIlosc()
                ))
                .toList();


    }
}
