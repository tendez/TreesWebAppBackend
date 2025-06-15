package czechowski.treeswebappbackend.service;

import czechowski.treeswebappbackend.dto.StoiskoDTO;
import czechowski.treeswebappbackend.repository.StoiskoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoiskoService {

    @Autowired
    private StoiskoRepository stoiskoRepository;


    public List<StoiskoDTO> findAllStoisko() {
        return stoiskoRepository.findAll()
                .stream()
                .map(stoisko -> new StoiskoDTO(
                        stoisko.getId(),
                        stoisko.getStoiskonazwa()))
                .toList();
    }
    public StoiskoDTO findStoiskoById(Integer id) {
        var stoisko = stoiskoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Stoisko nie znalezione"));
        return new StoiskoDTO(stoisko.getId(), stoisko.getStoiskonazwa());
    }
}
