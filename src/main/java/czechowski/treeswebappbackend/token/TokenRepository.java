package czechowski.treeswebappbackend.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token,Integer>{

    @Query("""
select t from Token t inner join Uzytkownicy  u on t.userID.id = u.id where u.id = :userID and (t.expired = false or t.revoked = false)""")

    List<Token> findAllValidTokenByUserID(Integer userID);

    Optional<Token> findByToken(String token);


}
