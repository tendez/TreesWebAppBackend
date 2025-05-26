package czechowski.treeswebappbackend.repository;


import czechowski.treeswebappbackend.model.Gatunek;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GatunekRepository extends JpaRepository<Gatunek, Integer> {
    

}
