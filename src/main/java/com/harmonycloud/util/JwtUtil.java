package com.harmonycloud.util;

import com.harmonycloud.entity.UserRole;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

public class JwtUtil {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);

    private String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkngXDsTy7Vuo1CcDu0mUP+3lN2JarCYJa6lDJhbBwUstEE/HCTtZwsgoWFJFb2T3WAxCsXlxYKo9DiWJbBeMV7TRTzKbAz0Wp4M6ygAWo3NLlzeOa+4cMOVQ9kq0doHormzxzA/tHXTx9BYBtZBJryuXL3+qxWsb0CLtMa/W6Gs1+zKxo3FGvW0t1QnoZfoJV1VF8kvSEsDpsmV3kqerE0cVPkn/BOZ22x32F8Q3k3g0+g9npWIUZ3zVn/pemuG7vYTtPjBKAJCKeFF86gW2Fqb0EjrGCZx7BCO4gV3Gb6vng2mLEb3DkIcGBelmE0rnYAmlYAtJnSxWVI8gNUhwlwIDAQAB";

    private String privateKey = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCSeBcOxPLtW6jUJwO7SZQ/7eU3YlqsJglrqUMmFsHBSy0QT8cJO1nCyChYUkVvZPdYDEKxeXFgqj0OJYlsF4xXtNFPMpsDPRangzrKABajc0uXN45r7hww5VD2SrR2geiubPHMD+0ddPH0FgG1kEmvK5cvf6rFaxvQIu0xr9boazX7MrGjcUa9bS3VCehl+glXVUXyS9ISwOmyZXeSp6sTRxU+Sf8E5nbbHfYXxDeTeDT6D2elYhRnfNWf+l6a4bu9hO0+MEoAkIp4UXzqBbYWpvQSOsYJnHsEI7iBXcZvq+eDaYsRvcOQhwYF6WYTSudgCaVgC0mdLFZUjyA1SHCXAgMBAAECggEATH1chUEDIEOa0lghkcAmJJCnAJpjgb1HdCrrv0tpGfmZaghPiBmvkZIXx7AHRNo0dY3Jkoc6V2HwCqA9uO4/Q1pRaIuj+jf/ybE1lWIgcHF4i1rfDKxHmp1W/5gZ0D2dduG8EHZMvPJinLaVY+0bHdik1pBUbU63MqXauvT6RVtUgZZP1hoD6O23ZYwMiCtib9gkisniaoLBn1CIZ4MDcWbn6dxne1yJLDeoVpP4ZFU3sVlmnekh5KcUhklNkdMvLOSeuchP0dFXDgQtwUDfJNd5JWFOVCo1f4yl3pAYZTvQp/+v4+6LDff4z4ft5HPjPrktGT85GRQDdJM6pX6u4QKBgQDWfyYj5UbiJxpVD+M4SChY/WIY8mSkYIEH5Tj/KfKddCOUdx4kBacMl47Q/131c1y/ztasVwVPA1CObNQthVcIftyuqhdp06VvO2GmiMlaBMAG0vB4mZ7Y47Tr5vW4atpV/G7iNpCQ5GriTLzg9VFAWzRT0/tNfOjmeUtBqukz5wKBgQCuz0WbdyMwjq6T9d83gFKbrNhupNMOVmjuSO9oDNQOyvnQrDYZsghOfEAs4VCoEwkI01bkE6eIxKn93xlEfG/ztqqcZ0y40LCbYZgbdB4s2966lj2n+IZp22wLIjZGuLlRxRb6uBuD+aGsLt9NO1fN6OwtsVcE3ie2X2pDFIBH0QKBgBf8tiYzgL7Pwqkakr17jE+PXoYNrWWYiTV50+rtJP2ovEXhIFTE8Q5+cHE87aQCV6/3kJhLTwOsCjkzQHMqwzXnAgTibqXeDlUnHd+C0omnmFXrBwtlmpcEt/ndpUMPaAVPqpLPqVEayj0uebzqkkCRMoPhY+wheOY1UE4yr8unAoGBAKawBlPEOs3mgBmebgbiWeMP4iE/EfGt+8iby42QDfU9HxEX5U6DMOCGIjupbduWqxq7SzOYejw0K1RlFBb2AVqHaBBTgBkLBhxj50Lmao+j6LJK6OfuV11BWbkUGmU9Z5jNMqhIPhSOSNeCqnNejs9Nt0eqvqtpmryQJydnuRrBAoGART1cwZj3Z3yLAqbWaxoOkCCoT0EGPTKi760R2eNaKwHn+lP9kO8y2DsvmtkwmANUoBOEW4tyqRjFxAAK+U5K6pkM9PHKq/q8+HbIUbCY1gg3KINHProsbFv3VCX+dcjuwMxtEPXna9GSTyn2ycMsiKLnVAuMBVG1antVQKrfGJ8=";

    private PrivateKey privateKeyObject;

    private PublicKey publicKeyObject;

    private String msg;

    @Autowired
    HttpServletRequest request;

    private long jwtExpirationInSec = 30 * 60;


    {
        try {
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            privateKeyObject = keyFactory.generatePrivate(keySpec);
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(publicKey));
            KeyFactory x509KeyFactory = KeyFactory.getInstance("RSA");
            publicKeyObject = x509KeyFactory.generatePublic(x509KeySpec);

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }

    }

    public  String generateToken(int userId, String englishGivenName, String englishSurName, List<UserRole> userRoles) {

        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInSec * 1000);

        HashMap<String, Object> claims = new HashMap<>();
        claims.put("userId", userId);
        claims.put("givenname", englishGivenName);
        claims.put("surname", englishSurName);

        List<String> roles = new ArrayList<>();
        for (int i = 0; i < userRoles.size(); i++) {
            if (userRoles.get(i).getUserRoleName().equals("Clerical staff")) {
                roles.add("ROLE_CLERICAL");
            } else if (userRoles.get(i).getUserRoleName().equals("Clinical staff")) {
                roles.add("ROLE_CLINICAL");
            } else {
                roles.add("ROLE_ADMIN");
            }
        }

        claims.put("roles", roles);
        return Jwts.builder().setClaims(claims).setSubject(String.valueOf(userId)).setIssuedAt(new Date()).setExpiration(expiryDate)
                .signWith(privateKeyObject).compact();
    }

    private String generateTokenByClaim(Claims claims) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInSec * 1000);
        String userId = claims.get("userId").toString();
        return Jwts.builder().setClaims(claims).setSubject(userId).setIssuedAt(new Date()).setExpiration(expiryDate)
                .signWith(privateKeyObject).compact();
    }

    public Map<String, Object> refreshToken(String oldToken) {
        msg = LogUtil.getRequest(request) + ", information='";

        Map<String, Object> result = new HashMap<>();
        try {
            Claims claims = Jwts.parser().setSigningKey(publicKeyObject).parseClaimsJws(oldToken).getBody();
            String refreshToken = generateTokenByClaim(claims);
            logger.info(msg + "refresh token success '");

            result.put("refresh", true);
            result.put("data", refreshToken);
        } catch (Exception e) {
            result.put("refresh", false);
            result.put("data", null);
        }
        return result;
    }

    public String getUserIdFromRequest(HttpServletRequest requests) {
        msg = LogUtil.getRequest(requests) + ", information='";
        if (requests != null) {
            String bearerToken = requests.getHeader("Authorization");
            logger.info(msg + "request token is :{}", bearerToken + "'");

            if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
                String jwt = bearerToken.substring(7, bearerToken.length());
                return getClaimsFromJWT(jwt).get("userId").toString();
            }
        }
        return null;
    }

    public Map<String, Object> getClaimsFromJWT(String jwt) {
        try {
            Claims claims = Jwts.parser().setSigningKey(publicKeyObject).parseClaimsJws(jwt).getBody();
            return claims;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getPublicKey() {
        return publicKey;
    }

}
