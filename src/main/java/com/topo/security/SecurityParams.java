package com.topo.security;

public interface SecurityParams {
    public static final String JWT_HEADER_NAME = "Authorization";
    public static final String SECRET = "yvan.kombou@gmail.com";
    public static final int DATE_EXPIRATION = 10*24*3600*1000;
    public static final String HEADER_PREFIX = "Bearer ";
}
