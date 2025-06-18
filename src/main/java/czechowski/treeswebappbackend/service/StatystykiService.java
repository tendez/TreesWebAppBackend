// src/main/java/czechowski/treeswebappbackend/service/StatystykiService.java
package czechowski.treeswebappbackend.service;

import czechowski.treeswebappbackend.dto.SprzedazPoDniachDTO;
import czechowski.treeswebappbackend.dto.SprzedazPoGatunkuDTO;
import czechowski.treeswebappbackend.dto.SprzedazPoRozmiarzeDTO;
import czechowski.treeswebappbackend.dto.StatystykiDTO;
import czechowski.treeswebappbackend.model.Sprzedaz;
import czechowski.treeswebappbackend.repository.SprzedazRepository;
import czechowski.treeswebappbackend.repository.StoiskoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StatystykiService {

    private final SprzedazRepository sprzedazRepository;
    private final StoiskoRepository stoiskoRepository;

    public StatystykiDTO getStatystykiByStoiskoId(Integer stoiskoId) {
        var stoisko = stoiskoRepository.findById(stoiskoId)
                .orElseThrow(() -> new RuntimeException("Stoisko nie znalezione"));

        var sprzedaze = sprzedazRepository.findByStoiskoID(stoisko);

        int liczbaSprzdazy = sprzedaze.size();
        BigDecimal lacznaWartosc = sprzedaze.stream()
                .map(Sprzedaz::getCena)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal sredniaCena = liczbaSprzdazy > 0
                ? lacznaWartosc.divide(BigDecimal.valueOf(liczbaSprzdazy), 2, RoundingMode.HALF_UP)
                : BigDecimal.ZERO;

        // Statystyki po gatunku
        var sprzedazPoGatunku = sprzedaze.stream()
                .collect(Collectors.groupingBy(s -> s.getGatunekID().getNazwagatunku()))
                .entrySet().stream()
                .map(entry -> new SprzedazPoGatunkuDTO(
                        entry.getKey(),
                        entry.getValue().size(),
                        entry.getValue().stream()
                                .map(Sprzedaz::getCena)
                                .reduce(BigDecimal.ZERO, BigDecimal::add)
                ))
                .collect(Collectors.toList());

        // Statystyki po rozmiarze
        var sprzedazPoRozmiarze = sprzedaze.stream()
                .collect(Collectors.groupingBy(s -> s.getWielkoscID().getOpiswielkosci()))
                .entrySet().stream()
                .map(entry -> new SprzedazPoRozmiarzeDTO(
                        entry.getKey(),
                        entry.getValue().size(),
                        entry.getValue().stream()
                                .map(Sprzedaz::getCena)
                                .reduce(BigDecimal.ZERO, BigDecimal::add)
                ))
                .collect(Collectors.toList());

        // Statystyki po dniach
        var sprzedazPoDniach = sprzedaze.stream()
                .collect(Collectors.groupingBy(s -> s.getDatasprzedazy().toString().split(" ")[0]))
                .entrySet().stream()
                .map(entry -> new SprzedazPoDniachDTO(
                        entry.getKey(),
                        entry.getValue().size(),
                        entry.getValue().stream()
                                .map(Sprzedaz::getCena)
                                .reduce(BigDecimal.ZERO, BigDecimal::add)
                ))
                .collect(Collectors.toList());

        return new StatystykiDTO(
                liczbaSprzdazy,
                lacznaWartosc,
                sredniaCena,
                sprzedazPoGatunku,
                sprzedazPoRozmiarze,
                sprzedazPoDniach
        );
    }

    public StatystykiDTO getStatystykiOgolne() {
        var wszystkieSprzedaze = sprzedazRepository.findAll();

        int liczbaSprzdazy = wszystkieSprzedaze.size();
        BigDecimal lacznaWartosc = wszystkieSprzedaze.stream()
                .map(Sprzedaz::getCena)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal sredniaCena = liczbaSprzdazy > 0
                ? lacznaWartosc.divide(BigDecimal.valueOf(liczbaSprzdazy), 2, RoundingMode.HALF_UP)
                : BigDecimal.ZERO;

        // Podobne grupowania jak wyżej, ale dla wszystkich sprzedaży
        var sprzedazPoGatunku = wszystkieSprzedaze.stream()
                .collect(Collectors.groupingBy(s -> s.getGatunekID().getNazwagatunku()))
                .entrySet().stream()
                .map(entry -> new SprzedazPoGatunkuDTO(
                        entry.getKey(),
                        entry.getValue().size(),
                        entry.getValue().stream()
                                .map(Sprzedaz::getCena)
                                .reduce(BigDecimal.ZERO, BigDecimal::add)
                ))
                .collect(Collectors.toList());

        var sprzedazPoRozmiarze = wszystkieSprzedaze.stream()
                .collect(Collectors.groupingBy(s -> s.getWielkoscID().getOpiswielkosci()))
                .entrySet().stream()
                .map(entry -> new SprzedazPoRozmiarzeDTO(
                        entry.getKey(),
                        entry.getValue().size(),
                        entry.getValue().stream()
                                .map(Sprzedaz::getCena)
                                .reduce(BigDecimal.ZERO, BigDecimal::add)
                ))
                .collect(Collectors.toList());

        var sprzedazPoDniach = wszystkieSprzedaze.stream()
                .collect(Collectors.groupingBy(s -> s.getDatasprzedazy().toString().split(" ")[0]))
                .entrySet().stream()
                .map(entry -> new SprzedazPoDniachDTO(
                        entry.getKey(),
                        entry.getValue().size(),
                        entry.getValue().stream()
                                .map(Sprzedaz::getCena)
                                .reduce(BigDecimal.ZERO, BigDecimal::add)
                ))
                .collect(Collectors.toList());

        return new StatystykiDTO(
                liczbaSprzdazy,
                lacznaWartosc,
                sredniaCena,
                sprzedazPoGatunku,
                sprzedazPoRozmiarze,
                sprzedazPoDniach
        );
    }
}
