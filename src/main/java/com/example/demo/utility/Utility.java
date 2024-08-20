package com.example.demo.utility;

import com.example.demo.auth.AuthUser;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


public class Utility {
    private Utility() {
        throw new IllegalStateException("Utility class");
    }

    public static String getUserName()
    {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        if(authentication==null || !authentication.isAuthenticated())
        {
            return "system";
        }
        if(authentication.getPrincipal() instanceof String)
        {
            return "system";
        }
        String name= ((AuthUser) authentication.getPrincipal()).getName();
        return name;

    }
//    public static String getUserId() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication == null || !authentication.isAuthenticated()) {
//            return "system";
//        }
//        if (authentication.getPrincipal() instanceof String) {
//            return (String) authentication.getPrincipal();
//        }
//        return ((AuthUser) authentication.getPrincipal()).getUserId();
//    }

//    public static Boolean validateToken(String token, String jwtSecret) {
//        try {
//            Jwts.parser().setSigningKey(jwtSecret.getBytes()).parseClaimsJws(token);
//            return true;
//        } catch (Exception ex) {
//            return false;
//        }
//    }

}
