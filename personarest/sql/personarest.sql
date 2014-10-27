CREATE TABLE persona(
	id INTEGER NOT NULL AUTO_INCREMENT,
	nombre VARCHAR(50) NOT NULL,
	apellido VARCHAR(50) NOT NULL,
	fechaNacimiento DATE,
	PRIMARY KEY (id)
);

INSERT INTO persona(nombre, apellido, fechaNacimiento)
VALUES('Juan', 'Pérez', '1980-01-01');
INSERT INTO persona(nombre, apellido, fechaNacimiento)
VALUES('Pedro', 'González', '1990-01-01');

SELECT * FROM persona;