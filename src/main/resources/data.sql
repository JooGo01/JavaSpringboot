CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL
);

INSERT INTO users (nombre, apellido) VALUES ('Ada', 'Turing');
INSERT INTO users (nombre, apellido) VALUES ('Ada', 'Lovelace');

CREATE TABLE IF NOT EXISTS canciones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    letra VARCHAR(255) NOT NULL,
    genero VARCHAR(255) NOT NULL
);

INSERT INTO canciones (nombre, letra, genero) VALUES ('Nombre1', 'Letra1', 'Jazz');
INSERT INTO canciones (nombre, letra, genero) VALUES ('Nombre2', 'Letra2', 'Blues');
