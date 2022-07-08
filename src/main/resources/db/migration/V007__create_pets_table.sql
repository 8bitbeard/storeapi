CREATE TABLE IF NOT EXISTS pets (
    id           uuid NOT NULL UNIQUE,
    birth_date   varchar(255) NOT NULL,
    name         varchar(255) NOT NULL,
    breed        varchar(255) NOT NULL,
    specie       varchar(255) NOT NULL,
    guardian_id  uuid NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (guardian_id) REFERENCES guardians(id)
                              ON DELETE CASCADE
);

INSERT INTO pets VALUES(uuid_generate_v4(), '2019-07-04 21:59:32.359', 'Vira lata', 'Pé de Pano', 'Cavalo',
        (select guardians.id from guardians where guardians.name LIKE 'Jhonny Cash'));
INSERT INTO pets VALUES(uuid_generate_v4(), '2019-07-04 21:59:32.359', 'Vira lata', 'Rex', 'Cachorro',
        (select guardians.id from guardians where guardians.name LIKE 'Sid Vicious'));
INSERT INTO pets VALUES(uuid_generate_v4(), '2019-07-04 21:59:32.359', 'Vira lata', 'Ajudante do Papai Noel', 'Cachorro',
        (select guardians.id from guardians where guardians.name LIKE 'Axl Rose'));
INSERT INTO pets VALUES(uuid_generate_v4(), '2019-07-04 21:59:32.359', 'Vira lata', 'Rex', 'Papagaio',
        (select guardians.id from guardians where guardians.name LIKE 'Joey Ramone'));
INSERT INTO pets VALUES(uuid_generate_v4(), '2019-07-04 21:59:32.359', 'Vira lata', 'Flora', 'Lhama',
        (select guardians.id from guardians where guardians.name LIKE 'Bruce Dickinson'));
INSERT INTO pets VALUES(uuid_generate_v4(), '2019-07-04 21:59:32.359', 'Vira lata', 'Dino', 'Iguana',
        (select guardians.id from guardians where guardians.name LIKE 'Kurt Cobain'));
INSERT INTO pets VALUES(uuid_generate_v4(), '2019-07-04 21:59:32.359', 'Vira lata', 'Lassie', 'Ornitorrinco',
        (select guardians.id from guardians where guardians.name LIKE 'Elvis Presley'));