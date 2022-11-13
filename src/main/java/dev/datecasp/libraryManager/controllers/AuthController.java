package dev.datecasp.libraryManager.controllers;

import dev.datecasp.libraryManager.entities.GrantedUser;
import dev.datecasp.libraryManager.repositories.GrantedUserRepository;
import dev.datecasp.libraryManager.security.jwt.JwtTokenUtil;
import dev.datecasp.libraryManager.security.payload.JwtResponse;
import dev.datecasp.libraryManager.security.payload.LoginRequest;
import dev.datecasp.libraryManager.security.payload.MessageResponse;
import dev.datecasp.libraryManager.security.payload.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

    /**
     * Controller to manage granted users authentication
     */
    @RestController
    @RequestMapping("/api/auth")
    public class AuthController
    {

        private final AuthenticationManager authManager;
        private final GrantedUserRepository grantedUserRepository;
        private final PasswordEncoder encoder;
        private final JwtTokenUtil jwtTokenUtil;

        public AuthController(AuthenticationManager authManager,
                              GrantedUserRepository userRepository,
                              GrantedUserRepository grantedUserRepository, PasswordEncoder encoder,
                              JwtTokenUtil jwtTokenUtil){
            this.authManager = authManager;
            this.grantedUserRepository = grantedUserRepository;
            this.encoder = encoder;
            this.jwtTokenUtil = jwtTokenUtil;
        }

        @PostMapping("/login")
        public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest){

            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = jwtTokenUtil.generateJwtToken(authentication);

            return ResponseEntity.ok(new JwtResponse(jwt));
        }

        @PostMapping("/register")
        public ResponseEntity<MessageResponse> register(@RequestBody RegisterRequest signUpRequest) {

            // Check 1: username
            if (grantedUserRepository.existsByUsername(signUpRequest.getUsername())) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: Username is already taken!"));
            }

            // Check 2: email
            if (grantedUserRepository.existsByEmail(signUpRequest.getEmail())) {
                return ResponseEntity
                        .badRequest()
                        .body(new MessageResponse("Error: Email is already in use!"));
            }

            // Create new user's account
            GrantedUser gUser = new GrantedUser(signUpRequest.getUsername(),
                    signUpRequest.getEmail(),
                    encoder.encode(signUpRequest.getPassword()));

            grantedUserRepository.save(gUser);

            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        }
    }

