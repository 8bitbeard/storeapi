CREATE TABLE IF NOT EXISTS addresses (
    id            uuid NOT NULL,
    bairro        varchar(255) NOT NULL,
    cep           varchar(255) NOT NULL,
    complemento   varchar(255) NOT NULL,
    localidade    varchar(255) NOT NULL,
    logradouro    varchar(255) NOT NULL,
    numero        varchar(255) NOT NULL,
    uf            varchar(255) NOT NULL,

    PRIMARY KEY (id)
);

INSERT INTO addresses VALUES(uuid_generate_v4(), 'Mapim', '78143442', 'Lado par', 'Várzea Grande', 'Rua Pingo de Ouro', '123', 'MT');
INSERT INTO addresses VALUES(uuid_generate_v4(), 'Centenário', '69312530', 'Ao lado do posto', 'Boa Vista', 'Travessa de Acesso I', '123', 'RR');
INSERT INTO addresses VALUES(uuid_generate_v4(), 'Jardim Planalto', '59155435', 'Bloco C, Apt 81', 'Parnamirim', 'Rua João Clímaco Nascimento', '123', 'RN');
INSERT INTO addresses VALUES(uuid_generate_v4(), 'Icuí-Guajará', '67125385', 'Torre 2', 'Ananindeua', 'Rua Tancredo Neves', '123', 'PA');
INSERT INTO addresses VALUES(uuid_generate_v4(), 'Itapuã', '29101523', 'Lado ímpar', 'Vila Velha', 'Rua Waldemar Verçosa Pitanga', '123', 'ES');
INSERT INTO addresses VALUES(uuid_generate_v4(), 'Jardim Jacira', '06864160', 'Final da rua', 'Itapecerica da Serra', 'Rua Machado de Assis', '123', 'SP');
INSERT INTO addresses VALUES(uuid_generate_v4(), 'Jardim dos Lagos', '07830540', 'Ao lado da padaria', 'Franco da Rocha', 'Rua Doutor Mário Toledo de Moraes', '123', 'SP');