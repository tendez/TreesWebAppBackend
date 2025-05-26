package czechowski.treeswebappbackend.controller;


import czechowski.treeswebappbackend.dto.StoiskoDTO;
import czechowski.treeswebappbackend.service.StoiskoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stoisko")
@RequiredArgsConstructor
public class StoiskoController {

    private final StoiskoService stoiskoService;

    @GetMapping
    public List<StoiskoDTO> getStoiska() {
        return stoiskoService.findAllStoisko();
    }
}

