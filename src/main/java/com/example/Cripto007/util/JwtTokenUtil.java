package com.example.Cripto007.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtTokenUtil {

    // ==================================================
    // 🔐 Clave secreta fija (mínimo 32 caracteres)
    // ==================================================
    private static final String SECRET_KEY = "ALIANZA_LIMA_TLV_LOS_UNICOS_TETRACAMPEONES_DEL_Y_DELMUNDO";

    // Duración del token (2 horas)
    private static final long JWT_EXPIRATION = 2 * 60 * 60 * 1000;

    // Convierte la cadena secreta en una Key válida para el algoritmo HS256
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    // ==================================================
    // 🪪 Generar Token
    // ==================================================
    public String generarToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // ==================================================
    // ✅ Validar Token
    // ==================================================
    public boolean validarToken(String token, String username) {
        final String usernameExtraido = obtenerUsuarioDeToken(token);
        return (usernameExtraido.equals(username) && !estaExpirado(token));
    }

    // ==================================================
    // 👤 Obtener usuario del Token
    // ==================================================
    public String obtenerUsuarioDeToken(String token) {
        return obtenerClaim(token, Claims::getSubject);
    }

    // ==================================================
    // ⏰ Verificar expiración
    // ==================================================
    private boolean estaExpirado(String token) {
        return obtenerFechaExpiracion(token).before(new Date());
    }

    private Date obtenerFechaExpiracion(String token) {
        return obtenerClaim(token, Claims::getExpiration);
    }

    // ==================================================
    // 🧩 Obtener cualquier claim del token
    // ==================================================
    public <T> T obtenerClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = obtenerTodosLosClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims obtenerTodosLosClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}