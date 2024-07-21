package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.security.AuthResponse;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.security.AuthenticationRequest;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.security.RegisterRequest;

public interface AuthService {
    AuthResponse register(RegisterRequest request);
    AuthResponse authenticate(AuthenticationRequest request);
}


