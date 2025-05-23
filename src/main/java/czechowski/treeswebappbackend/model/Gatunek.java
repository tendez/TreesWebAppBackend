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
@Table(name = "gatunek")
public class Gatunek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gatunekID", nullable = false)
    private Integer id;

    @Nationalized
    @Column(name = "nazwagatunku", nullable = false)
    private String nazwagatunku;

    @OneToMany(mappedBy = "gatunekid")
    private Set<Magazyn> magazyns = new LinkedHashSet<>();

    @OneToMany(mappedBy = "gatunekID")
    private Set<Sprzedaz> sprzedazs = new LinkedHashSet<>();

}