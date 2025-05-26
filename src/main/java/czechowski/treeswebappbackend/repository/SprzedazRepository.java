package czechowski.treeswebappbackend.repository;


import czechowski.treeswebappbackend.model.Sprzedaz;
import czechowski.treeswebappbackend.model.Stoisko;
import czechowski.treeswebappbackend.model.Uzytkownicy;
import czechowski.treeswebappbackend.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SprzedazRepository extends JpaRepository<Sprzedaz, Integer> {

    List<Sprzedaz> findAllSprzedazByStoiskoID(Stoisko stoiskoID);
    List<Sprzedaz> findAllByUserID(Uzytkownicy userID);
    List<Sprzedaz> findAllByUserIDAndDatasprzedazy(Uzytkownicy userID, LocalDate datasprzedazy);



}
