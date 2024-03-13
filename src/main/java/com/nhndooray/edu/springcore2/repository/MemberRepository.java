package com.nhndooray.edu.springcore2.repository;

import com.nhndooray.edu.springcore2.domain.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends ListCrudRepository<Member, Long>, InsertableRepository<Member> {

}
