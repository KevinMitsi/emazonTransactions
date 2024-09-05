package com.kevin.emazon_transacciones.infraestucture.security.util;
import io.jsonwebtoken.security.Keys;


import javax.crypto.SecretKey;

public class ConstansUtilSecurityClass {
    private ConstansUtilSecurityClass(){}
    private static final String SECRET = "mySuperSecretKeyForJwtSigningBecauseIwantToProtectMyUsersInformationsAndDataForWorkingInMyApplication012345678910111213141516171819";
    public static final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes());
    public static final String PREFIX_TOKEN = "Bearer ";
    public static final String HEADER_AUTHORIZATION = "Authorization";



}