package com.dbserver.desafio_votacao.util;

import java.util.UUID;

public class UuidUtil {

    public static String generateUuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
