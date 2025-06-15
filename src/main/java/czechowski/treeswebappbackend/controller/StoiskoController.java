package czechowski.treeswebappbackend.controller;


import czechowski.treeswebappbackend.dto.StoiskoDTO;
import czechowski.treeswebappbackend.service.StoiskoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/stoisko")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class StoiskoController {

    private final StoiskoService stoiskoService;

    @GetMapping
    public List<StoiskoDTO> getStoiska() {
        return stoiskoService.findAllStoisko();
    }

    @GetMapping("/{id}")
    public StoiskoDTO getStoiskoById(@PathVariable("id") Integer id) {
        return stoiskoService.findStoiskoById(id);
    }

}

