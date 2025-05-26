package czechowski.treeswebappbackend.controller;

import czechowski.treeswebappbackend.dto.StoiskoDTO;
import czechowski.treeswebappbackend.dto.WielkoscDTO;
import czechowski.treeswebappbackend.service.WielkoscService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/wielkosc")
@RequiredArgsConstructor
public class WielkoscController {

    private final WielkoscService wielkoscService;

    @GetMapping
    public List<WielkoscDTO> getWielkosci() {
        return wielkoscService.findAllWielkosc();
    }
}
