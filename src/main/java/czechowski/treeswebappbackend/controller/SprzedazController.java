package czechowski.treeswebappbackend.controller;


import czechowski.treeswebappbackend.dto.CreateSprzedazRequest;
import czechowski.treeswebappbackend.dto.SprzedazDTO;
import czechowski.treeswebappbackend.dto.SprzedazDetailDTO;
import czechowski.treeswebappbackend.model.Stoisko;
import czechowski.treeswebappbackend.model.Uzytkownicy;
import czechowski.treeswebappbackend.service.SprzedazService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sprzedaz")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class SprzedazController {

    private final SprzedazService sprzedazService;

    @GetMapping("/bystoiskoid/{id}")
    public List<SprzedazDTO> getSprzedazByStoiskoId(@PathVariable("id") Stoisko stoiskoId) {
        return sprzedazService.findSprzedazDTOsByStoiskoId(stoiskoId);
    }

    @GetMapping("/byuserid/{id}")
    public List<SprzedazDTO> getSprzedazByUserId(@PathVariable("id") Uzytkownicy userId) {
        return sprzedazService.findSprzedazDTOsByUserID(userId);

    }
    @GetMapping("/details/bystoiskoid/{id}")
    public List<SprzedazDetailDTO> getSprzedazDetailsById(@PathVariable("id") Stoisko stoiskoId) {
        return sprzedazService.findSprzedazDetailsById(stoiskoId);
    }

    @GetMapping("/details/byuserid/{id}")
    public List<SprzedazDetailDTO> getSprzedazDetailsByUserId(@PathVariable("id") Uzytkownicy userId) {
        return sprzedazService.findSprzedazDetailsByUserId(userId);
    }

    @PostMapping
    public ResponseEntity<SprzedazDTO> addSprzedaz(@RequestBody CreateSprzedazRequest request, Authentication authentication) {
        try {

            String userLogin = authentication.getName();
            SprzedazDTO sprzedazDTO = sprzedazService.createSprzedaz(request, userLogin);
            return ResponseEntity.ok(sprzedazDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
