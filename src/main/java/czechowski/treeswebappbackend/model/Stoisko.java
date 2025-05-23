package czechowski.treeswebappbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "stoisko")
public class Stoisko {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stoiskoID", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "stoiskonazwa", nullable = false)
    private String stoiskonazwa;

    @OneToMany(mappedBy = "stoiskoid")
    private Set<Magazyn> magazyns = new LinkedHashSet<>();

    @OneToMany(mappedBy = "stoiskoID")
    private Set<Sprzedaz> sprzedazs = new LinkedHashSet<>();

}