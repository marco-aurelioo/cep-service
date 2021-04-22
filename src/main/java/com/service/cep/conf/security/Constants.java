package com.service.cep.conf.security;

import org.springframework.beans.factory.annotation.Value;

abstract class Constants {

    public static final String PRIVATE_KEY = "S0m3p121V@t31<3y";
    public static final Long EXPIRATION_TIME = 864000000L;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

}
