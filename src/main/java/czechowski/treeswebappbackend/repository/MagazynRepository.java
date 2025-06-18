package czechowski.treeswebappbackend.repository;

import czechowski.treeswebappbackend.model.Gatunek;
import czechowski.treeswebappbackend.model.Magazyn;
import czechowski.treeswebappbackend.model.Stoisko;
import czechowski.treeswebappbackend.model.Wielkosc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface MagazynRepository extends JpaRepository<Magazyn, Integer> {

    List<Magazyn> findByStoiskoid(Stoisko stoisko);

    Optional<Magazyn> findByStoiskoidAndGatunekidAndWielkoscid(
            Stoisko stoisko,
            Gatunek gatunek,
            Wielkosc wielkosc
    );
}

