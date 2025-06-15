package czechowski.treeswebappbackend.controller;


import czechowski.treeswebappbackend.dto.GatunekDTO;
import czechowski.treeswebappbackend.service.GatunekService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gatunek")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class GatunekController {

    private final GatunekService gatunekService;

    @GetMapping
    public List<GatunekDTO> getGatunki() {
        return gatunekService.findAllGatunek();
    }

    @GetMapping("/{id}")
    public GatunekDTO getGatunekById(@PathVariable("id") Integer id) {
        return gatunekService.findGatunekById(id);
    }

}
