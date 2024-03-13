package com.nhndooray.edu.springcore2.repository;

import com.nhndooray.edu.springcore2.domain.Password;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordRepository extends ListCrudRepository<Password, Long>, InsertableRepository<Password> {

}
