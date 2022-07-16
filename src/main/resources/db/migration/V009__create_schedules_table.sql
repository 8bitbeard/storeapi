CREATE TABLE IF NOT EXISTS schedules (
    id              uuid NOT NULL UNIQUE,
    schedule_time   timestamp NOT NULL,
    guardian_id     uuid NOT NULL,
    pet_id          uuid NOT NULL,
    service_id    uuid NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY(guardian_id) REFERENCES guardians(id),
    FOREIGN KEY(pet_id) REFERENCES pets(id),
    FOREIGN KEY(service_id) REFERENCES services(id)
);

INSERT INTO schedules VALUES (uuid_generate_v4(), '2022-07-05 15:00:00.000',
        (SELECT guardians.id from guardians where guardians.name LIKE 'Sid Vicious'),
        (select pets.id from pets where pets.guardian_id = (SELECT guardians.id from guardians where guardians.name LIKE 'Sid Vicious')),
        (select services.id from services where services.description LIKE 'Banho'));
INSERT INTO schedules VALUES (uuid_generate_v4(), '2022-07-05 15:30:00.000',
        (SELECT guardians.id from guardians where guardians.name LIKE 'Sid Vicious'),
        (select pets.id from pets where pets.guardian_id = (SELECT guardians.id from guardians where guardians.name LIKE 'Sid Vicious')),
        (select services.id from services where services.description LIKE 'Tosa'));
INSERT INTO schedules VALUES (uuid_generate_v4(), '2022-07-05 15:00:00.000',
        (SELECT guardians.id from guardians where guardians.name LIKE 'Axl Rose'),
        (select pets.id from pets where pets.guardian_id = (SELECT guardians.id from guardians where guardians.name LIKE 'Axl Rose')),
        (select services.id from services where services.description LIKE 'Tosa'));
INSERT INTO schedules VALUES (uuid_generate_v4(), '2022-07-05 15:30:00.000',
        (SELECT guardians.id from guardians where guardians.name LIKE 'Axl Rose'),
        (select pets.id from pets where pets.guardian_id = (SELECT guardians.id from guardians where guardians.name LIKE 'Axl Rose')),
        (select services.id from services where services.description LIKE 'Banho'));
INSERT INTO schedules VALUES (uuid_generate_v4(), '2022-07-05 16:00:00.000',
        (SELECT guardians.id from guardians where guardians.name LIKE 'Axl Rose'),
        (select pets.id from pets where pets.guardian_id = (SELECT guardians.id from guardians where guardians.name LIKE 'Axl Rose')),
        (select services.id from services where services.description LIKE 'Consulta Clínica'));