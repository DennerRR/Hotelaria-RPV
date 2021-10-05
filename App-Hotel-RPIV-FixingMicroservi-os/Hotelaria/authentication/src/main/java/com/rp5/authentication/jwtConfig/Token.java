package com.rp5.authentication.jwtConfig;

import com.rp5.authentication.model.Cargo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class Token {
    @Value("${security.jwt.token.secret_key:key_rp5}")
    private String secretKey;

    @Value("${security.jwt.token.expire_time:3600000}")
    private long validityInMilliseconds = 3600000; // 1 hora

    @Autowired
    private UsuarioDetails usuarioDetails;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String criarToken(String nomeUsuario, List<Cargo> cargos) {
        Claims claims = Jwts.claims().setSubject(nomeUsuario);
        claims.put("authentication", cargos.stream()
                .map(s -> new SimpleGrantedAuthority(s.getAuthority()))
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = usuarioDetails.loadUserByUsername(getNomeUsuario(token));
         return new UsernamePasswordAuthenticationToken(userDetails,  "", userDetails.getAuthorities());
    }

    public String getNomeUsuario(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public String resolverToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if(bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public boolean validarToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new HttpExc("Token não válido ou expirado", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
