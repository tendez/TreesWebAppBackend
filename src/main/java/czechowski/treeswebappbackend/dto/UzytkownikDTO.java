package czechowski.treeswebappbackend.dto;

public record UzytkownikDTO(
        Integer uzytkownikId,
        String login,
        String role
) {
}