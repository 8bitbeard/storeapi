CREATE TABLE IF NOT EXISTS users_roles (
    user_id uuid NOT NULL,
    role_id uuid NOT NULL,

    FOREIGN KEY (user_id) REFERENCES users(id)
                          ON DELETE CASCADE,
    FOREIGN KEY (role_id) REFERENCES roles(id)
                          ON DELETE CASCADE
);

INSERT INTO users_roles(user_id, role_id)
VALUES ((select users.id from users where users.email LIKE 'admin@store.com'),
        (select roles.id from roles where roles.name LIKE 'ROLE_ADMIN'));
INSERT INTO users_roles(user_id, role_id)
VALUES ((select users.id from users where users.email LIKE 'jhonny.cash@example.com'),
        (select roles.id from roles where roles.name LIKE 'ROLE_CLIENT'));
INSERT INTO users_roles(user_id, role_id)
VALUES ((select users.id from users where users.email LIKE 'sid.vicious@example.com'),
        (select roles.id from roles where roles.name LIKE 'ROLE_CLIENT'));
INSERT INTO users_roles(user_id, role_id)
VALUES ((select users.id from users where users.email LIKE 'axl.rose@example.com'),
        (select roles.id from roles where roles.name LIKE 'ROLE_CLIENT'));
INSERT INTO users_roles(user_id, role_id)
VALUES ((select users.id from users where users.email LIKE 'joey.ramone@example.com'),
        (select roles.id from roles where roles.name LIKE 'ROLE_CLIENT'));
INSERT INTO users_roles(user_id, role_id)
VALUES ((select users.id from users where users.email LIKE 'bruce.dickinson@example.com'),
        (select roles.id from roles where roles.name LIKE 'ROLE_CLIENT'));
INSERT INTO users_roles(user_id, role_id)
VALUES ((select users.id from users where users.email LIKE 'kurt.cobain@example.com'),
        (select roles.id from roles where roles.name LIKE 'ROLE_CLIENT'));
INSERT INTO users_roles(user_id, role_id)
VALUES ((select users.id from users where users.email LIKE 'elvis.presley@example.com'),
        (select roles.id from roles where roles.name LIKE 'ROLE_CLIENT'));