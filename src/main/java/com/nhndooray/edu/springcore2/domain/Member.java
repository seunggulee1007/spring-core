package com.nhndooray.edu.springcore2.domain;

import lombok.Generated;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@ToString
@Getter
@Table("members")
public class Member {

    @Id
    @Column("member_id")
    private Long id;

    @Column("user_code")
    private String userCode;

    @Column("join_at")
    private LocalDateTime joinAt;

    protected Member() {
    }

    public Member(String userCode) {
        this.id = PrimaryKey.generate();
        this.userCode = userCode;
        this.joinAt = LocalDateTime.now();
    }

    public Member(String userCode, LocalDateTime joinAt) {
        this.id = PrimaryKey.generate();
        this.userCode = userCode;
        this.joinAt = joinAt;
    }
}
