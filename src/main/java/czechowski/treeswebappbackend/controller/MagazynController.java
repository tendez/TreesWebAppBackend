// src/main/java/czechowski/treeswebappbackend/controller/MagazynController.java
package czechowski.treeswebappbackend.controller;

import czechowski.treeswebappbackend.dto.MagazynDTO;
import czechowski.treeswebappbackend.dto.UpdateMagazynRequest;
import czechowski.treeswebappbackend.service.MagazynService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/magazyn")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class MagazynController {

    private final MagazynService magazynService;

    @GetMapping("/{id}")
    public List<MagazynDTO> getMagazynByStoiskoId(@PathVariable("id") Integer stoiskoId) {
        return magazynService.findAllMagazynByStoiskoId(stoiskoId);
    }

    @PostMapping("/update")
    public ResponseEntity<MagazynDTO> updateMagazyn(@RequestBody UpdateMagazynRequest request) {
        try {
            MagazynDTO magazynDTO = magazynService.updateMagazyn(request);
            return ResponseEntity.ok(magazynDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/add")
    public ResponseEntity<MagazynDTO> addToMagazyn(@RequestBody UpdateMagazynRequest request) {
        try {
            MagazynDTO magazynDTO = magazynService.addToMagazyn(request);
            return ResponseEntity.ok(magazynDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/subtract")
    public ResponseEntity<MagazynDTO> subtractFromMagazyn(@RequestBody UpdateMagazynRequest request) {
        try {
            MagazynDTO magazynDTO = magazynService.subtractFromMagazyn(request);
            return ResponseEntity.ok(magazynDTO);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
