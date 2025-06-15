package czechowski.treeswebappbackend.controller;

import czechowski.treeswebappbackend.dto.WielkoscDTO;
import czechowski.treeswebappbackend.service.WielkoscService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/wielkosc")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class WielkoscController {

    private final WielkoscService wielkoscService;

    @GetMapping
    public List<WielkoscDTO> getWielkosci() {
        return wielkoscService.findAllWielkosc();
    }

    @GetMapping("/{id}")
    public WielkoscDTO getWielkoscById(@PathVariable("id") Integer id) {
        return wielkoscService.findWielkoscById(id);
    }

}
