package czechowski.treeswebappbackend.auth;

import czechowski.treeswebappbackend.config.JwtService;
import czechowski.treeswebappbackend.model.Uzytkownicy;
import czechowski.treeswebappbackend.repository.UzytkownicyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UzytkownicyRepository repository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse register(RegisterRequest registerRequest) {

        var user = Uzytkownicy.builder()
                .login(registerRequest.getLogin())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role("user")
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }


    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword()));
        var user = repository.findByLogin(request.getLogin()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
