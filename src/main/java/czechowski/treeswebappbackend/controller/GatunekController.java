package czechowski.treeswebappbackend.controller;


import czechowski.treeswebappbackend.dto.GatunekDTO;
import czechowski.treeswebappbackend.service.GatunekService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gatunek")
@RequiredArgsConstructor
public class GatunekController {

    private final GatunekService gatunekService;

    @GetMapping
    public List<GatunekDTO> getGatunki() {
        return gatunekService.findAllGatunek();
    }
}
