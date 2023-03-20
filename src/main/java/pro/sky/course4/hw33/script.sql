CREATE DATABASE skypro;
\c skypro

CREATE TABLE employee
(
    id         BIGSERIAL   NOT NULL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name  VARCHAR(50) NOT NULL,
    gender     VARCHAR(6)  NOT NULL,
    age        INT         NOT NULL
);

INSERT INTO employee(id, first_name, last_name, gender, age)
    VALUES (1, 'Vasiliy', 'Pupkin', 'male', 33);
INSERT INTO employee(id, first_name, last_name, gender, age)
    VALUES (2, 'Elizaveta', 'Kurashova', 'female', 27);
INSERT INTO employee(id, first_name, last_name, gender, age)
    VALUES (3, 'Andrey', 'Petrov', 'mtf', 26);
SELECT * FROM employee;

UPDATE employee SET first_name = 'Vladimir' WHERE id = 1;
SELECT * FROM employee;

DELETE FROM employee WHERE gender = 'mtf';
SELECT * FROM employee;
