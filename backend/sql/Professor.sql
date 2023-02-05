create database education_management;

use education_management;

CREATE TABLE Professors (
    professor_id INT AUTO_INCREMENT PRIMARY KEY,
    professor_username VARCHAR(100) NOT NULL,
    professor_password VARCHAR(100) NOT NULL,
    professor_department VARCHAR(100) NOT NULL,
    professor_salary INT NOT NULL
);

INSERT INTO Professors (professor_username, professor_password, professor_department, professor_salary) VALUES
    ('professor1', 'password1', 'department1', 1000),
    ('professor2', 'password2', 'department2', 2000),
    ('professor3', 'password3', 'department3', 4000),
    ('professor4', 'password4', 'department4', 5000),
    ('professor5', 'password5', 'department5', 6000);