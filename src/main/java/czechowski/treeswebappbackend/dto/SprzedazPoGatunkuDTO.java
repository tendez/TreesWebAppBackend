package czechowski.treeswebappbackend.dto;

import java.math.BigDecimal;

public record SprzedazPoGatunkuDTO(
        String gatunekNazwa,
        Integer liczbaSprzdazy,
        BigDecimal lacznaWartosc
) {
}
