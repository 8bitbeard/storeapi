CREATE TABLE IF NOT EXISTS guardians (
    id      uuid NOT NULL UNIQUE,
    document varchar(255) NOT NULL UNIQUE,
    name     varchar(255) NOT NULL,
    phone    varchar(255) NOT NULL,
    user_id    uuid NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users(id)
                          ON DELETE CASCADE
);