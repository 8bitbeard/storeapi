CREATE TABLE IF NOT EXISTS users (
    id uuid NOT NULL UNIQUE,
    email varchar(255) NOT NULL UNIQUE,
    password varchar(255) NOT NULL,

    PRIMARY KEY (id)
);

INSERT INTO users VALUES(uuid_generate_v4(), 'admin@store.com', '$2a$10$3vzpe5qOD78X/85Jvem30OGhTWB6RUoI3Jp26rJjAtlv.OHE8lP12');
INSERT INTO users VALUES(uuid_generate_v4(), 'jhonny.cash@example.com', '$2a$10$3vzpe5qOD78X/85Jvem30OGhTWB6RUoI3Jp26rJjAtlv.OHE8lP12');
INSERT INTO users VALUES(uuid_generate_v4(), 'sid.vicious@example.com', '$2a$10$3vzpe5qOD78X/85Jvem30OGhTWB6RUoI3Jp26rJjAtlv.OHE8lP12');
INSERT INTO users VALUES(uuid_generate_v4(), 'axl.rose@example.com', '$2a$10$3vzpe5qOD78X/85Jvem30OGhTWB6RUoI3Jp26rJjAtlv.OHE8lP12');
INSERT INTO users VALUES(uuid_generate_v4(), 'joey.ramone@example.com', '$2a$10$3vzpe5qOD78X/85Jvem30OGhTWB6RUoI3Jp26rJjAtlv.OHE8lP12');
INSERT INTO users VALUES(uuid_generate_v4(), 'bruce.dickinson@example.com', '$2a$10$3vzpe5qOD78X/85Jvem30OGhTWB6RUoI3Jp26rJjAtlv.OHE8lP12');
INSERT INTO users VALUES(uuid_generate_v4(), 'kurt.cobain@example.com', '$2a$10$3vzpe5qOD78X/85Jvem30OGhTWB6RUoI3Jp26rJjAtlv.OHE8lP12');
INSERT INTO users VALUES(uuid_generate_v4(), 'elvis.presley@example.com', '$2a$10$3vzpe5qOD78X/85Jvem30OGhTWB6RUoI3Jp26rJjAtlv.OHE8lP12');