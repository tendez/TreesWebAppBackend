package czechowski.treeswebappbackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "sprzedaz")
public class Sprzedaz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sprzedazID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userID", nullable = false)
    private Uzytkownicy userID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "gatunekID", nullable = false)
    private Gatunek gatunekID;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "wielkoscID", nullable = false)
    private Wielkosc wielkoscID;

    @Column(name = "cena", nullable = false, precision = 10, scale = 2)
    private BigDecimal cena;

    @Column(name = "datasprzedazy", nullable = false)
    private LocalDate datasprzedazy;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "stoiskoID", nullable = false)
    private Stoisko stoiskoID;

}