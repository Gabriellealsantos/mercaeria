package br.edu.ifba.saj.fwads.model;

import java.util.UUID;

public class IdGenerator {

    public static <T> T gerarNovoId(Class<T> tipoIdClass) {
        return tipoIdClass.cast(UUID.randomUUID());
    }

}
