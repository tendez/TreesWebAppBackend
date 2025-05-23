package czechowski.treeswebappbackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import czechowski.treeswebappbackend.model.Uzytkownicy;

import java.util.Optional;

public interface UzytkownicyRepository extends JpaRepository<Uzytkownicy, Integer> {


    Optional<Uzytkownicy> findByLogin(String login);

}
