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
@Table(name = "wielkosc")
public class Wielkosc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "wielkoscID", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "opiswielkosci", nullable = false)
    private String opiswielkosci;

    @OneToMany(mappedBy = "wielkoscid")
    private Set<Magazyn> magazyns = new LinkedHashSet<>();

    @OneToMany(mappedBy = "wielkoscID")
    private Set<Sprzedaz> sprzedazs = new LinkedHashSet<>();

}