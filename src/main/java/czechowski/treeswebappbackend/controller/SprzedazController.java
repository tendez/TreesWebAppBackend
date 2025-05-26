package czechowski.treeswebappbackend.controller;


import czechowski.treeswebappbackend.dto.SprzedazDTO;
import czechowski.treeswebappbackend.model.Stoisko;
import czechowski.treeswebappbackend.model.Uzytkownicy;
import czechowski.treeswebappbackend.service.SprzedazService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/bystoiskoid/{id}")
    public List<SprzedazDTO> getSprzedazByStoiskoId(@PathVariable("id") Stoisko stoiskoId){
        return sprzedazService.findSprzedazDTOsByStoiskoId(stoiskoId);
    }
    @GetMapping("/byuserid/{id}")
    public List<SprzedazDTO> getSprzedazByUserId(@PathVariable("id")Uzytkownicy userId){
        return sprzedazService.findSprzedazDTOsByUserID(userId);

    }





}
