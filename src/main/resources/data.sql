--CREATE EXTENSION IF NOT EXISTS "uuid-ossp";


--INSERT INTO roles VALUES(uuid_generate_v4(), 'ROLE_ADMIN');
--INSERT INTO roles VALUES(uuid_generate_v4(), 'ROLE_CLIENT');
--
--
--INSERT INTO users VALUES(uuid_generate_v4(), 'admin@store.com', '$2a$10$3vzpe5qOD78X/85Jvem30OGhTWB6RUoI3Jp26rJjAtlv.OHE8lP12');
--INSERT INTO users VALUES(uuid_generate_v4(), 'jhonny.cash@example.com', '$2a$10$3vzpe5qOD78X/85Jvem30OGhTWB6RUoI3Jp26rJjAtlv.OHE8lP12');
--INSERT INTO users VALUES(uuid_generate_v4(), 'sid.vicious@example.com', '$2a$10$3vzpe5qOD78X/85Jvem30OGhTWB6RUoI3Jp26rJjAtlv.OHE8lP12');
--INSERT INTO users VALUES(uuid_generate_v4(), 'axl.rose@example.com', '$2a$10$3vzpe5qOD78X/85Jvem30OGhTWB6RUoI3Jp26rJjAtlv.OHE8lP12');
--INSERT INTO users VALUES(uuid_generate_v4(), 'joey.ramone@example.com', '$2a$10$3vzpe5qOD78X/85Jvem30OGhTWB6RUoI3Jp26rJjAtlv.OHE8lP12');
--INSERT INTO users VALUES(uuid_generate_v4(), 'bruce.dickinson@example.com', '$2a$10$3vzpe5qOD78X/85Jvem30OGhTWB6RUoI3Jp26rJjAtlv.OHE8lP12');
--INSERT INTO users VALUES(uuid_generate_v4(), 'kurt.cobain@example.com', '$2a$10$3vzpe5qOD78X/85Jvem30OGhTWB6RUoI3Jp26rJjAtlv.OHE8lP12');
--INSERT INTO users VALUES(uuid_generate_v4(), 'elvis.presley@example.com', '$2a$10$3vzpe5qOD78X/85Jvem30OGhTWB6RUoI3Jp26rJjAtlv.OHE8lP12');
--
--
--INSERT INTO users_roles(user_id, role_id)
--VALUES ((select users.id from users where users.email LIKE 'admin@store.com'),
--        (select roles.id from roles where roles.name LIKE 'ROLE_ADMIN'));
--INSERT INTO users_roles(user_id, role_id)
--VALUES ((select users.id from users where users.email LIKE 'jhonny.cash@example.com'),
--        (select roles.id from roles where roles.name LIKE 'ROLE_CLIENT'));
--INSERT INTO users_roles(user_id, role_id)
--VALUES ((select users.id from users where users.email LIKE 'sid.vicious@example.com'),
--        (select roles.id from roles where roles.name LIKE 'ROLE_CLIENT'));
--INSERT INTO users_roles(user_id, role_id)
--VALUES ((select users.id from users where users.email LIKE 'axl.rose@example.com'),
--        (select roles.id from roles where roles.name LIKE 'ROLE_CLIENT'));
--INSERT INTO users_roles(user_id, role_id)
--VALUES ((select users.id from users where users.email LIKE 'joey.ramone@example.com'),
--        (select roles.id from roles where roles.name LIKE 'ROLE_CLIENT'));
--INSERT INTO users_roles(user_id, role_id)
--VALUES ((select users.id from users where users.email LIKE 'bruce.dickinson@example.com'),
--        (select roles.id from roles where roles.name LIKE 'ROLE_CLIENT'));
--INSERT INTO users_roles(user_id, role_id)
--VALUES ((select users.id from users where users.email LIKE 'kurt.cobain@example.com'),
--        (select roles.id from roles where roles.name LIKE 'ROLE_CLIENT'));
--INSERT INTO users_roles(user_id, role_id)
--VALUES ((select users.id from users where users.email LIKE 'elvis.presley@example.com'),
--        (select roles.id from roles where roles.name LIKE 'ROLE_CLIENT'));
--
--
--INSERT INTO addresses VALUES(uuid_generate_v4(), 'Mapim', '78143442', 'Lado par', 'Várzea Grande', 'Rua Pingo de Ouro', '123', 'MT');
--INSERT INTO addresses VALUES(uuid_generate_v4(), 'Centenário', '69312530', 'Ao lado do posto', 'Boa Vista', 'Travessa de Acesso I', '123', 'RR');
--INSERT INTO addresses VALUES(uuid_generate_v4(), 'Jardim Planalto', '59155435', 'Bloco C, Apt 81', 'Parnamirim', 'Rua João Clímaco Nascimento', '123', 'RN');
--INSERT INTO addresses VALUES(uuid_generate_v4(), 'Icuí-Guajará', '67125385', 'Torre 2', 'Ananindeua', 'Rua Tancredo Neves', '123', 'PA');
--INSERT INTO addresses VALUES(uuid_generate_v4(), 'Itapuã', '29101523', 'Lado ímpar', 'Vila Velha', 'Rua Waldemar Verçosa Pitanga', '123', 'ES');
--INSERT INTO addresses VALUES(uuid_generate_v4(), 'Jardim Jacira', '06864160', 'Final da rua', 'Itapecerica da Serra', 'Rua Machado de Assis', '123', 'SP');
--INSERT INTO addresses VALUES(uuid_generate_v4(), 'Jardim dos Lagos', '07830540', 'Ao lado da padaria', 'Franco da Rocha', 'Rua Doutor Mário Toledo de Moraes', '123', 'SP');
--
--
--INSERT INTO guardians VALUES(uuid_generate_v4(), '75487323097', 'Jhonny Cash', '11999999999',
--        (select addresses.id from addresses where addresses.cep LIKE '69312530'),
--        (select users.id from users where users.email LIKE 'jhonny.cash@example.com'));
--INSERT INTO guardians VALUES(uuid_generate_v4(), '93423054077', 'Sid Vicious', '11999999999',
--        (select addresses.id from addresses where addresses.cep LIKE '69312530'),
--        (select users.id from users where users.email LIKE 'sid.vicious@example.com'));
--INSERT INTO guardians VALUES(uuid_generate_v4(), '59634759025', 'Axl Rose', '11999999999',
--        (select addresses.id from addresses where addresses.cep LIKE '69312530'),
--        (select users.id from users where users.email LIKE 'axl.rose@example.com'));
--INSERT INTO guardians VALUES(uuid_generate_v4(), '79809228082', 'Joey Ramone', '11999999999',
--        (select addresses.id from addresses where addresses.cep LIKE '69312530'),
--        (select users.id from users where users.email LIKE 'joey.ramone@example.com'));
--INSERT INTO guardians VALUES(uuid_generate_v4(), '02154245064', 'Bruce Dickinson', '11999999999',
--        (select addresses.id from addresses where addresses.cep LIKE '69312530'),
--        (select users.id from users where users.email LIKE 'bruce.dickinson@example.com'));
--INSERT INTO guardians VALUES(uuid_generate_v4(), '00622729004', 'Kurt Cobain', '11999999999',
--        (select addresses.id from addresses where addresses.cep LIKE '69312530'),
--        (select users.id from users where users.email LIKE 'kurt.cobain@example.com'));
--INSERT INTO guardians VALUES(uuid_generate_v4(), '35937029089', 'Elvis Presley', '11999999999',
--        (select addresses.id from addresses where addresses.cep LIKE '69312530'),
--        (select users.id from users where users.email LIKE 'elvis.presley@example.com'));
--
--
--INSERT INTO pets VALUES(uuid_generate_v4(), '2019-07-04 21:59:32.359', 'Vira lata', 'Pé de Pano', 'Cavalo',
--        (select guardians.id from guardians where guardians.name LIKE 'Jhonny Cash'));
--INSERT INTO pets VALUES(uuid_generate_v4(), '2019-07-04 21:59:32.359', 'Vira lata', 'Rex', 'Cachorro',
--        (select guardians.id from guardians where guardians.name LIKE 'Sid Vicious'));
--INSERT INTO pets VALUES(uuid_generate_v4(), '2019-07-04 21:59:32.359', 'Vira lata', 'Ajudante do Papai Noel', 'Cachorro',
--        (select guardians.id from guardians where guardians.name LIKE 'Axl Rose'));
--INSERT INTO pets VALUES(uuid_generate_v4(), '2019-07-04 21:59:32.359', 'Vira lata', 'Rex', 'Papagaio',
--        (select guardians.id from guardians where guardians.name LIKE 'Joey Ramone'));
--INSERT INTO pets VALUES(uuid_generate_v4(), '2019-07-04 21:59:32.359', 'Vira lata', 'Flora', 'Lhama',
--        (select guardians.id from guardians where guardians.name LIKE 'Bruce Dickinson'));
--INSERT INTO pets VALUES(uuid_generate_v4(), '2019-07-04 21:59:32.359', 'Vira lata', 'Dino', 'Iguana',
--        (select guardians.id from guardians where guardians.name LIKE 'Kurt Cobain'));
--INSERT INTO pets VALUES(uuid_generate_v4(), '2019-07-04 21:59:32.359', 'Vira lata', 'Lassie', 'Ornitorrinco',
--        (select guardians.id from guardians where guardians.name LIKE 'Elvis Presley'));
--
--
--INSERT INTO procedures VALUES (uuid_generate_v4(), 'Consulta Clínica', 100.00);
--INSERT INTO procedures VALUES (uuid_generate_v4(), 'Tosa', 50.00);
--INSERT INTO procedures VALUES (uuid_generate_v4(), 'Banho', 50.00);
--
--
--INSERT INTO schedules VALUES (uuid_generate_v4(), '2022-07-05 15:00:00.000',
--        (SELECT guardians.id from guardians where guardians.name LIKE 'Sid Vicious'),
--        (select pets.id from pets where pets.guardian_id = (SELECT guardians.id from guardians where guardians.name LIKE 'Sid Vicious')),
--        (select procedures.id from procedures where procedures.description LIKE 'Banho'));
--INSERT INTO schedules VALUES (uuid_generate_v4(), '2022-07-05 15:30:00.000',
--        (SELECT guardians.id from guardians where guardians.name LIKE 'Sid Vicious'),
--        (select pets.id from pets where pets.guardian_id = (SELECT guardians.id from guardians where guardians.name LIKE 'Sid Vicious')),
--        (select procedures.id from procedures where procedures.description LIKE 'Tosa'));
--INSERT INTO schedules VALUES (uuid_generate_v4(), '2022-07-05 15:00:00.000',
--        (SELECT guardians.id from guardians where guardians.name LIKE 'Axl Rose'),
--        (select pets.id from pets where pets.guardian_id = (SELECT guardians.id from guardians where guardians.name LIKE 'Axl Rose')),
--        (select procedures.id from procedures where procedures.description LIKE 'Tosa'));
--INSERT INTO schedules VALUES (uuid_generate_v4(), '2022-07-05 15:30:00.000',
--        (SELECT guardians.id from guardians where guardians.name LIKE 'Axl Rose'),
--        (select pets.id from pets where pets.guardian_id = (SELECT guardians.id from guardians where guardians.name LIKE 'Axl Rose')),
--        (select procedures.id from procedures where procedures.description LIKE 'Banho'));
--INSERT INTO schedules VALUES (uuid_generate_v4(), '2022-07-05 16:00:00.000',
--        (SELECT guardians.id from guardians where guardians.name LIKE 'Axl Rose'),
--        (select pets.id from pets where pets.guardian_id = (SELECT guardians.id from guardians where guardians.name LIKE 'Axl Rose')),
--        (select procedures.id from procedures where procedures.description LIKE 'Consulta Clínica'));
