package com.martins.code.codeblog_backend.authentication.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.martins.code.codeblog_backend.authentication.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class TokenService {

    @Value("${codeblog.security}")
    private String secret;

    public String createToken(User user) {
        try{
            Algorithm alg = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("login-auth-codeblog")
                    .withSubject(user.getEmail())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 2 /*== 2 horas*/))
                    .sign(alg);
            return token;
        } catch (JWTCreationException e) {
            throw new RuntimeException("Erro ao autenticar o token", e);
        }
    }

    public String verifyToken(String token) {
        try{
            Algorithm alg = Algorithm.HMAC256(secret);
            return JWT.require(alg)
                    .withIssuer("login-auth-codeblog")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException e) {
            return null;
        }
    }
}
