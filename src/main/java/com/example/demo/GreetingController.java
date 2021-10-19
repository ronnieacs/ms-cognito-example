package com.example.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class GreetingController {

    @GetMapping("/all")
    public Mono<Greeting> all(Authentication auth) {
        Jwt jwt = (Jwt) auth.getPrincipal();
        return Mono.just(new Greeting("Hello " + jwt.getClaimAsString("username") + "!"));
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('SCOPE_aws.cognito.signin.user.admin')")
    public Mono<Greeting> admin(Authentication auth) {
        Jwt jwt = (Jwt) auth.getPrincipal();
        return Mono.just(new Greeting("Hello admin " + jwt.getClaimAsString("username") + "!"));
    }

    @GetMapping("/no-admin")
    @PreAuthorize("!hasAuthority('SCOPE_aws.cognito.signin.user.admin')")
    public Mono<Greeting> noAdmin(Authentication auth) {
        Jwt jwt = (Jwt) auth.getPrincipal();
        return Mono.just(new Greeting("Hello no admin " + jwt.getClaimAsString("username") + "!"));
    }
}