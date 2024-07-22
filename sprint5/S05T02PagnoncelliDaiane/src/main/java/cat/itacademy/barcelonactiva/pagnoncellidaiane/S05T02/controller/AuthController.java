package cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.controller;

import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.User;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.model.entity.Role;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.service.impl.UserServiceImpl;
import cat.itacademy.barcelonactiva.pagnoncellidaiane.S05T02.config.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody Map<String, String> userRequest) {
        String email = userRequest.get("email");
        String firstName = userRequest.get("firstName");
        String lastName = userRequest.get("lastName");
        String password = userRequest.get("password");
        Role role = Role.valueOf(userRequest.get("role").toUpperCase());

        User createdUser = userService.createUser(email, firstName, lastName, password, role);
        return ResponseEntity.ok(createdUser);
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> loginUser(@RequestBody Map<String, String> loginRequest) {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String jwt = jwtService.generateToken(userDetails);
        Map<String, String> response = new HashMap<>();
        response.put("token", jwt);
        return ResponseEntity.ok(response);
    }
}











