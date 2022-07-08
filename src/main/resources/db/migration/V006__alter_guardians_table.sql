ALTER TABLE guardians
    ADD address_id uuid NOT NULL,
    ADD FOREIGN KEY(address_id) REFERENCES addresses(id);

INSERT INTO guardians VALUES(uuid_generate_v4(), '75487323097', 'Jhonny Cash', '11999999999',
        (select users.id from users where users.email LIKE 'jhonny.cash@example.com'),
        (select addresses.id from addresses where addresses.cep LIKE '78143442'));
INSERT INTO guardians VALUES(uuid_generate_v4(), '93423054077', 'Sid Vicious', '11999999999',
        (select users.id from users where users.email LIKE 'sid.vicious@example.com'),
        (select addresses.id from addresses where addresses.cep LIKE '69312530'));
INSERT INTO guardians VALUES(uuid_generate_v4(), '59634759025', 'Axl Rose', '11999999999',
        (select users.id from users where users.email LIKE 'axl.rose@example.com'),
        (select addresses.id from addresses where addresses.cep LIKE '59155435'));
INSERT INTO guardians VALUES(uuid_generate_v4(), '79809228082', 'Joey Ramone', '11999999999',
        (select users.id from users where users.email LIKE 'joey.ramone@example.com'),
        (select addresses.id from addresses where addresses.cep LIKE '67125385'));
INSERT INTO guardians VALUES(uuid_generate_v4(), '02154245064', 'Bruce Dickinson', '11999999999',
        (select users.id from users where users.email LIKE 'bruce.dickinson@example.com'),
        (select addresses.id from addresses where addresses.cep LIKE '29101523'));
INSERT INTO guardians VALUES(uuid_generate_v4(), '00622729004', 'Kurt Cobain', '11999999999',
        (select users.id from users where users.email LIKE 'kurt.cobain@example.com'),
        (select addresses.id from addresses where addresses.cep LIKE '06864160'));
INSERT INTO guardians VALUES(uuid_generate_v4(), '35937029089', 'Elvis Presley', '11999999999',
        (select users.id from users where users.email LIKE 'elvis.presley@example.com'),
        (select addresses.id from addresses where addresses.cep LIKE '07830540'));