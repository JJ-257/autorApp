package com.autorapp.autorApp.controller;

import com.autorapp.autorApp.model.User;
import com.autorapp.autorApp.service.MyUserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/login", method = RequestMethod.POST)
public class UserController {

    private MyUserDetailsService userService;

    public ResponseEntity<User> prijavaKorisnika(@RequestBody String token) {
            byte[] decoded = Base64.getDecoder().decode(token);
            String authorization = new String(decoded, StandardCharsets.UTF_8);
            String[] userNameAndPass = authorization.split(":");

            /*String[] userNameAndPass = token.split(":");*/
            User korisnik = (User) userService.loadUserByUsername(userNameAndPass[0]);
            if (korisnik.getPassword().equals(userNameAndPass[1])) {
                return new ResponseEntity<>(korisnik, HttpStatus.OK);
            }

            return (ResponseEntity<User>) ResponseEntity.internalServerError();

    }
}
