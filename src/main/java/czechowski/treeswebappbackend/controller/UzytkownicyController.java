
package czechowski.treeswebappbackend.controller;

import czechowski.treeswebappbackend.dto.UzytkownikDTO;
import czechowski.treeswebappbackend.service.UzytkownicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class UzytkownicyController {

    private final UzytkownicyService uzytkownikService;

    @GetMapping("/me")
    public UzytkownikDTO getCurrentUser(Authentication authentication) {
        String userLogin = authentication.getName();
        return uzytkownikService.findByLogin(userLogin);
    }
}
