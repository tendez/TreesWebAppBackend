package czechowski.treeswebappbackend.repository;

import czechowski.treeswebappbackend.model.Magazyn;

import czechowski.treeswebappbackend.model.Stoisko;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MagazynRepository  extends JpaRepository<Magazyn, Integer> {



        List<Magazyn> findMagazynByStoiskoid(Stoisko stoiskoID);
}
