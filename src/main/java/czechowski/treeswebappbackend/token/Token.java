package czechowski.treeswebappbackend.token;

import czechowski.treeswebappbackend.model.Uzytkownicy;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {

    @Id
    @GeneratedValue
    private Integer id;
    private String token;

    @Enumerated(EnumType.STRING)
    private TokenType tokenType;

    private boolean expired;
    private boolean revoked;


    @ManyToOne
    @JoinColumn(name = "userID")
    private Uzytkownicy userID;

}
