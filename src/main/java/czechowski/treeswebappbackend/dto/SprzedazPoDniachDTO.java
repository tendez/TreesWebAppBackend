package czechowski.treeswebappbackend.dto;

import java.math.BigDecimal;

public record SprzedazPoDniachDTO(
        String data,
        Integer liczbaSprzdazy,
        BigDecimal lacznaWartosc
) {
}
