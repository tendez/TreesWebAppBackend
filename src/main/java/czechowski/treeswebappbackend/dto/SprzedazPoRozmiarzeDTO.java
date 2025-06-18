
package czechowski.treeswebappbackend.dto;

import java.math.BigDecimal;

public record SprzedazPoRozmiarzeDTO(
        String rozmiarNazwa,
        Integer liczbaSprzdazy,
        BigDecimal lacznaWartosc
) {
}
