CREATE TABLE IF NOT EXISTS users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    apellido VARCHAR(255) NOT NULL
);

INSERT INTO users (nombre, apellido) VALUES ('Ada', 'Turing');
INSERT INTO users (nombre, apellido) VALUES ('Ada', 'Lovelace');

/*
CREATE TABLE IF NOT EXISTS canciones (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    letra VARCHAR(255) NOT NULL,
    genero VARCHAR(255) NOT NULL
);

INSERT INTO canciones (nombre, letra, genero) VALUES ('Nombre1', 'Letra1', 'Jazz');
INSERT INTO canciones (nombre, letra, genero) VALUES ('Nombre2', 'Letra2', 'Blues');
*/

CREATE TABLE IF NOT EXISTS artista (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    pais VARCHAR(255),
    fecha_nacimiento TIMESTAMP,
    fecha_fallecimiento TIMESTAMP,
    biografia VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS instrumento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS artista_instrumento (
    id INT PRIMARY KEY AUTO_INCREMENT,
    artista_id INT,
    instrumento_id INT,
    FOREIGN KEY (artista_id) REFERENCES artista(id),
    FOREIGN KEY (instrumento_id) REFERENCES instrumento(id)
);

CREATE TABLE IF NOT EXISTS disco (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255),
    fecha_lanzamiento TIMESTAMP,
    artista_id INT,
    FOREIGN KEY (artista_id) REFERENCES artista(id)
);

CREATE TABLE IF NOT EXISTS genero (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS cancion (
   id INT PRIMARY KEY AUTO_INCREMENT,
   nombre VARCHAR(255),
   letra VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS disco_cancion (
   id INT PRIMARY KEY AUTO_INCREMENT,
   disco_id INT,
   cancion_id INT,
   FOREIGN KEY (disco_id) REFERENCES disco(id),
   FOREIGN KEY (cancion_id) REFERENCES cancion(id)
);

CREATE TABLE IF NOT EXISTS cancion_genero (
   id INT PRIMARY KEY AUTO_INCREMENT,
   cancion_id INT,
   genero_id INT,
   FOREIGN KEY (cancion_id) REFERENCES cancion(id),
   FOREIGN KEY (genero_id) REFERENCES genero(id)
);

CREATE TABLE IF NOT EXISTS disco_genero (
   id INT PRIMARY KEY AUTO_INCREMENT,
   disco_id INT,
   genero_id INT,
   FOREIGN KEY (disco_id) REFERENCES disco(id),
   FOREIGN KEY (genero_id) REFERENCES genero(id)
);

CREATE TABLE IF NOT EXISTS artista_genero (
    id INT PRIMARY KEY AUTO_INCREMENT,
    artista_id INT,
    genero_id INT,
    FOREIGN KEY (artista_id) REFERENCES artista(id),
    FOREIGN KEY (genero_id) REFERENCES genero(id)
);

-- inserts tablas
-- Tabla artista
INSERT INTO artista (nombre, pais, fecha_nacimiento, fecha_fallecimiento, biografia)
VALUES ('John Doe', 'Escocia', '1980-01-01 00:00:00', NULL, 'Biografía de John Doe'),
       ('Jane Smith', 'Alemania', '1975-05-15 00:00:00', '2020-05-15 00:00:00', 'Biografía de Jane Smith');

-- Tabla instrumento
INSERT INTO instrumento (nombre)
VALUES ('Guitarra'),
       ('Piano');

-- Tabla artista_instrumento
INSERT INTO artista_instrumento (artista_id, instrumento_id)
VALUES (1, 1),
       (2, 2);

-- Tabla disco
INSERT INTO disco (nombre, fecha_lanzamiento, artista_id)
VALUES ('Disco A', '2000-01-01 00:00:00', 1),
       ('Disco B', '2005-05-05 00:00:00', 2);

-- Tabla genero
INSERT INTO genero (nombre)
VALUES ('Jazz'),
       ('Blues'),
       ('Rock'),
       ('Electrónica'),
       ('Clásica'),
       ('Tango');
/*Jazz, Blues, Rock, Electrónica, Clásica, Tango;*/
-- Tabla cancion
INSERT INTO cancion (nombre, letra)
VALUES ('Cancion 1', 'Letra de la cancion 1'),
       ('Cancion 2', 'Letra de la cancion 2');

-- Tabla disco_cancion
INSERT INTO disco_cancion (disco_id, cancion_id)
VALUES (1, 1),
       (2, 2);

-- Tabla cancion_genero
INSERT INTO cancion_genero (cancion_id, genero_id)
VALUES (1, 1),
       (1, 2),
       (2, 2);

-- Tabla disco_genero
INSERT INTO disco_genero (disco_id, genero_id)
VALUES (1, 1),
       (2, 2);

-- Tabla artista_genero
INSERT INTO artista_genero (artista_id, genero_id)
VALUES (1, 1),
       (2, 2);
