package czechowski.treeswebappbackend.controller;


import czechowski.treeswebappbackend.dto.MagazynDTO;
import czechowski.treeswebappbackend.model.Stoisko;
import czechowski.treeswebappbackend.service.MagazynService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/magazyn")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class MagazynController {

    private final MagazynService magazynService;


    @GetMapping("{id}")
    public List<MagazynDTO> getMagazynByStoiskoId(@PathVariable("id") Stoisko stoiskoId) {
        return magazynService.findAllMagazyn(stoiskoId);
    }
}
