
package czechowski.treeswebappbackend.dto;

public record UpdateMagazynRequest(
        Integer stoiskoId,
        Integer gatunekId,
        Integer wielkoscId,
        Integer ilosc
) {
}
