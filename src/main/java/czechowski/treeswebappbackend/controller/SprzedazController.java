package czechowski.treeswebappbackend.controller;


import czechowski.treeswebappbackend.dto.SprzedazDTO;
import czechowski.treeswebappbackend.model.Sprzedaz;
import czechowski.treeswebappbackend.model.Stoisko;
import czechowski.treeswebappbackend.service.SprzedazService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sprzedaz")
@RequiredArgsConstructor
public class SprzedazController {

    private final SprzedazService sprzedazService;

    @GetMapping("{stoiskoId}")
    public List<SprzedazDTO> getSprzedaz(@PathVariable("stoiskoId") Stoisko stoiskoId){
        return sprzedazService.findSprzedazDTOsByStoiskoId(stoiskoId);
    }
}
