
package czechowski.treeswebappbackend.service;

import czechowski.treeswebappbackend.dto.UzytkownikDTO;
import czechowski.treeswebappbackend.repository.UzytkownicyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UzytkownicyService {

    private final UzytkownicyRepository uzytkownicyRepository;

    public UzytkownikDTO findByLogin(String login) {
        var user = uzytkownicyRepository.findByLogin(login)
                .orElseThrow(() -> new RuntimeException("Użytkownik nie znaleziony"));

        return new UzytkownikDTO(
                user.getId(),
                user.getLogin(),
                user.getRole()
        );
    }
}
