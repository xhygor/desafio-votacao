package com.dbserver.desafio_votacao.util;

import java.io.Serializable;

public abstract class BaseService<T, ID extends Serializable> {

    private final BaseRepository<T, ID> baseRepository;

    public BaseService(BaseRepository<T, ID> baseRepository) {
        this.baseRepository = baseRepository;
    }

    public T salvar(T entity) {
        return baseRepository.save(entity);
    }
}
