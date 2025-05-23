package czechowski.treeswebappbackend.repository;


import czechowski.treeswebappbackend.model.Gatunek;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GatunekRepository extends JpaRepository<Gatunek, Long> {
}
