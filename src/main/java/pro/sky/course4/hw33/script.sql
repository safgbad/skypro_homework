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


-- Создайте таблицу city с колонками city_id и city_name.
CREATE TABLE city
(
    city_id   BIGSERIAL   NOT NULL PRIMARY KEY,
    city_name VARCHAR(50) NOT NULL
);

-- Добавьте в таблицу employee колонку city_id.
ALTER TABLE employee
    ADD city_id BIGINT;

-- Назначьте ее внешним ключом и свяжите с таблицей city.
ALTER TABLE employee
    ADD CONSTRAINT fk_employee_city
        FOREIGN KEY (city_id) REFERENCES city (city_id);

-- Заполните таблицу city
INSERT INTO city (city_id, city_name)
    VALUES (1, 'Saint-Petersburg');
INSERT INTO city (city_id, city_name)
    VALUES (2, 'Moscow');
INSERT INTO city (city_id, city_name)
    VALUES (3, 'Kazan');
INSERT INTO city (city_id, city_name)
    VALUES (4, 'Omsk');

-- Назначьте работникам соответствующие города.
UPDATE employee SET city_id = 1 WHERE id = 1;
UPDATE employee SET city_id = 2 WHERE id = 2;
UPDATE employee SET city_id = 3 WHERE id = 3;
UPDATE employee SET city_id = 1 WHERE id = 4;


-- Получите имена и фамилии сотрудников, а также города, в которых они проживают.
SELECT e.first_name,
       e.last_name,
       COALESCE(c.city_name, 'null') AS city_name
FROM employee e
LEFT JOIN city c ON e.city_id = c.city_id;

-- Получите города, а также имена и фамилии сотрудников, которые в них проживают.
-- Если в городе никто из сотрудников не живет, то вместо имени должен стоять null.
SELECT c.city_name,
       COALESCE(e.first_name, 'null') AS first_name,
       COALESCE(e.last_name, 'null') AS last_name
FROM employee e
RIGHT JOIN city c ON c.city_id = e.city_id;

-- Получите имена всех сотрудников и названия всех городов.
-- Если в городе не живет никто из сотрудников, то вместо имени должен стоять null.
-- Аналогично, если города для какого-то из сотрудников нет в списке, так же должен быть получен null.
SELECT COALESCE(e.first_name, 'null') AS first_name,
       COALESCE(e.last_name, 'null') AS last_name,
       COALESCE(c.city_name, 'null') AS city_name
FROM employee e
FULL OUTER JOIN city c ON c.city_id = e.city_id;

-- Получите таблицу, в которой каждому имени должен соответствовать каждый город.
SELECT e.first_name,
       e.last_name,
       c.city_name
FROM employee e
CROSS JOIN city c
ORDER BY e.id;
