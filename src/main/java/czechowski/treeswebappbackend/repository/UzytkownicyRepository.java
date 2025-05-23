package czechowski.treeswebappbackend.repository;


import czechowski.treeswebappbackend.model.Uzytkownicy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UzytkownicyRepository extends JpaRepository<Uzytkownicy, Integer> {


    Optional<Uzytkownicy> findByLogin(String login);

}
