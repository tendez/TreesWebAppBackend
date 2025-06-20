package czechowski.treeswebappbackend.service;

import czechowski.treeswebappbackend.dto.WielkoscDTO;
import czechowski.treeswebappbackend.repository.WielkoscRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WielkoscService {

    @Autowired
    private WielkoscRepository wielkoscRepository;

    public List<WielkoscDTO> findAllWielkosc() {
        return wielkoscRepository.findAll()
                .stream()
                .map(wielkosc -> new WielkoscDTO(
                        wielkosc.getId(),
                        wielkosc.getOpiswielkosci()))
                .toList();


    }

    public WielkoscDTO findWielkoscById(Integer id) {
        var wielkosc = wielkoscRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Wielkość nie znaleziona"));
        return new WielkoscDTO(wielkosc.getId(), wielkosc.getOpiswielkosci());
    }
}
