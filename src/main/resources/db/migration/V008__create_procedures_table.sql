CREATE TABLE IF NOT EXISTS procedures (
    id           uuid NOT NULL UNIQUE,
    description  varchar(255) NOT NULL UNIQUE,
    value        numeric NOT NULL,

    PRIMARY KEY (id)
);

INSERT INTO procedures VALUES (uuid_generate_v4(), 'Consulta Clínica', 100.00);
INSERT INTO procedures VALUES (uuid_generate_v4(), 'Tosa', 50.00);
INSERT INTO procedures VALUES (uuid_generate_v4(), 'Banho', 50.00);