package czechowski.treeswebappbackend.dto;

public record CreateSprzedazRequest(
        Integer gatunekId,
        Integer wielkoscId,
        Integer stoiskoId,
        Integer cena
) {
}
