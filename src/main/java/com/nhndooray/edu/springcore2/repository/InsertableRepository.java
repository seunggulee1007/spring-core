package com.nhndooray.edu.springcore2.repository;

public interface InsertableRepository<T> {

    <S extends T> S insert(S entity);

}
