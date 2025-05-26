package czechowski.treeswebappbackend.dto;

public record SprzedazDTO (

    Integer sprzedazId,
    Integer gatunekId,
    Integer wielkoscId,
    Integer stoiskoId,
    Integer uzytkownikId,
    Integer cena,
    String data
){
}
