
package czechowski.treeswebappbackend.dto;

public record SprzedazDetailDTO(
        Integer sprzedazId,
        String gatunekNazwa,
        String wielkoscNazwa,
        String stoiskoNazwa,
        String uzytkownikLogin,
        Integer cena,
        String data
) {
}
