package czechowski.treeswebappbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "magazyn")
public class Magazyn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "magazynID", nullable = false)
    private Integer id;

    @Column(name = "ilosc", nullable = false)
    private Integer ilosc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wielkoscid")
    private Wielkosc wielkoscid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gatunekid")
    private Gatunek gatunekid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stoiskoid")
    private Stoisko stoiskoid;

}