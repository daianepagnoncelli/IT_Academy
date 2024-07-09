package cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.controller;

import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.security.JwtTokenUtil;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.model.JwtRequest;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.model.JwtResponse;
import cat.itacademy.barcelonactiva.pagnoncelli.daiane.s05.t02.service.JwtUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @PostMapping("/login")
    public JwtResponse createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return new JwtResponse(token);
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        return userDetailsService.saveUser(username, password);
    }
}

