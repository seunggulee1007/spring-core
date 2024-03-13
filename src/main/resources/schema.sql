DROP TABLE if EXISTS members CASCADE;
CREATE TABLE members
(
    member_id BIGINT,
    user_code VARCHAR(30),
    join_at TIMESTAMP,
    PRIMARY KEY(member_id)
);

DROP TABLE if EXISTS passwords CASCADE;
CREATE TABLE passwords
(
    password_id BIGINT,
    member_id BIGINT,
    password VARCHAR(32),
    created_at TIMESTAMP,
    PRIMARY KEY(password_id),
    FOREIGN KEY(member_id) REFERENCES members(member_id)
);

