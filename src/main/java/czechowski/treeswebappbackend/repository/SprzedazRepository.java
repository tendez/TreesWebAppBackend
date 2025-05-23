package czechowski.treeswebappbackend.repository;



import czechowski.treeswebappbackend.model.Stoisko;
import czechowski.treeswebappbackend.model.Uzytkownicy;
import org.springframework.data.jpa.repository.JpaRepository;
import czechowski.treeswebappbackend.model.Sprzedaz;

import java.util.List;

public interface SprzedazRepository extends JpaRepository<Sprzedaz, Long> {


}
