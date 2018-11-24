package com.badminton.security;

public class SevurityConstants {

    static final String SECRET = "SECRET_KEY";
    static final String TOKEN_PREFIX = "BEARER";
    static final String HEADER = "AUTHORIZATION";
    static final String SIGN_UP_URL = "/users/addUser";
    static final String LOGIN_URL = "/api/auth/login";
    static final long EXPIRATION_TIME = 840000000;
}
