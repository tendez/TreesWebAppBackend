package czechowski.treeswebappbackend.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import czechowski.treeswebappbackend.model.Gatunek;

public interface GatunekRepository extends JpaRepository<Gatunek, Long> {}
