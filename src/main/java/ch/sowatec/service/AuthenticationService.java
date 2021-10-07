package ch.sowatec.service;

import io.smallrye.jwt.build.Jwt;
import org.eclipse.microprofile.jwt.Claims;

import javax.enterprise.context.RequestScoped;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashSet;
/**
 * @author gatzka
 * @version 1.0.0-Snapshot
 * Project: Issues
 */
@RequestScoped
public class AuthenticationService {

    public String generateJWTToken(String username){
        return Jwt.issuer("https://www.sowatec.com")
                .upn(username)
                .groups(new HashSet<>(Arrays.asList("User","Admin")))
                .claim(Claims.birthdate.name(),"2001-07-13")
                .expiresIn(Duration.ofHours(1))
                .sign();
    }
}
