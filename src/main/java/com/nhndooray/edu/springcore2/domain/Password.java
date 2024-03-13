package com.nhndooray.edu.springcore2.domain;

import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@ToString
@Getter
@Table("passwords")
public class Password {

    @Id
    @Column("password_id")
    private Long id;

    @Column("member_id")
    private Long memberId;

    @Column("password")
    private String password;

    @Column("created_at")
    private LocalDateTime createdAt;

    protected Password() {
    }

    public Password(Member member, String password) {
        this.id = PrimaryKey.generate();
        this.memberId = member.getId();
        this.password = password;
        this.createdAt = LocalDateTime.now();
    }
}
