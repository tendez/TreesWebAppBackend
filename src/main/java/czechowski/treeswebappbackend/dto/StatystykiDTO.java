package czechowski.treeswebappbackend.dto;

import java.math.BigDecimal;
import java.util.List;

public record StatystykiDTO(
        Integer liczbaSprzdazy,
        BigDecimal lacznaWartoscSprzedazy,
        BigDecimal sredniaCenaSprzedazy,
        List<SprzedazPoGatunkuDTO> sprzedazPoGatunku,
        List<SprzedazPoRozmiarzeDTO> sprzedazPoRozmiarze,
        List<SprzedazPoDniachDTO> sprzedazPoDniach
) {
}
