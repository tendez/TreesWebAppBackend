package czechowski.treeswebappbackend.controller;

import czechowski.treeswebappbackend.dto.StatystykiDTO;
import czechowski.treeswebappbackend.service.StatystykiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/statystyki")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class StatystykiController {

    private final StatystykiService statystykiService;

    @GetMapping("/stoisko/{id}")
    public StatystykiDTO getStatystykiByStoiskoId(@PathVariable("id") Integer stoiskoId) {
        return statystykiService.getStatystykiByStoiskoId(stoiskoId);
    }

    @GetMapping("/ogolne")
    public StatystykiDTO getStatystykiOgolne() {
        return statystykiService.getStatystykiOgolne();
    }
}
