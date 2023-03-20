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

-- Получите информацию об именах и фамилиях по всем сотрудникам.
-- Колонки должны называться «Имя» и «Фамилия».
SELECT first_name AS Имя,
       last_name  AS Фамилия
FROM employee;

-- Получите всю информацию о сотрудниках, которые младше 30 или старше 50 лет.
SELECT *
FROM employee
WHERE age < 30
   OR age > 50;

-- Получите всю информацию о сотрудниках, которым от 30 до 50 лет.
SELECT *
FROM employee
WHERE age >= 30
  AND age <= 50;

-- Выведите полный список сотрудников, которые отсортированы
-- по фамилиям в обратном порядке.
SELECT last_name, first_name, id, gender, age
FROM employee
ORDER BY last_name DESC;

-- Выведите сотрудников, имена которых длиннее 4 символов.
SELECT first_name, last_name, id, gender, age
FROM employee
WHERE LENGTH(first_name) > 4;


-- Измените имена у двух сотрудников так, чтобы на 5 сотрудников
-- было только 3 разных имени, то есть чтобы получились две пары
-- тезок и один сотрудник с уникальным именем.
UPDATE employee
SET first_name = 'Vladimir'
WHERE id = 3;
UPDATE employee
SET first_name = 'Elizaveta'
WHERE id = 4;

-- Посчитайте суммарный возраст для каждого имени.
-- Выведите в двух столбцах «имя» и «суммарный возраст».
SELECT first_name,
       SUM(age) AS total_age
FROM employee
GROUP BY first_name;

-- Выведите имя и самый юный возраст, соответствующий имени.
SELECT first_name,
       MIN(age) AS min_age
FROM employee
GROUP BY first_name;

-- Выведите имя и максимальный возраст только для неуникальных имен.
-- Результат отсортируйте по возрасту в порядке возрастания.
SELECT first_name,
       MAX(age) AS namesakes_max_age
FROM employee
GROUP BY first_name
HAVING COUNT(*) > 1
ORDER BY namesakes_max_age DESC;
