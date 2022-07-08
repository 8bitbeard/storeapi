CREATE TABLE IF NOT EXISTS roles (
    id uuid NOT NULL UNIQUE,
    name varchar(255) NOT NULL UNIQUE,

    PRIMARY KEY (id)
);

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

INSERT INTO roles VALUES(uuid_generate_v4(), 'ROLE_ADMIN');
INSERT INTO roles VALUES(uuid_generate_v4(), 'ROLE_CLIENT');