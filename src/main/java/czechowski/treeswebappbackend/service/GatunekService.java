package czechowski.treeswebappbackend.service;


import czechowski.treeswebappbackend.dto.GatunekDTO;
import czechowski.treeswebappbackend.repository.GatunekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GatunekService {

    @Autowired
    private GatunekRepository gatunekRepository;

    public List<GatunekDTO> findAllGatunek() {
        return gatunekRepository.findAll()
                .stream()
                .map(gatunek -> new GatunekDTO(
                        gatunek.getId(),
                        gatunek.getNazwagatunku()))
                .toList();


    }

}
