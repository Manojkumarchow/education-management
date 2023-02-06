-- create database education_management;

use education_management;

CREATE TABLE professors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    professorusername VARCHAR(100) NOT NULL,
    professorpassword VARCHAR(100) NOT NULL,
    professordepartment VARCHAR(100) NOT NULL,
    professorsalary INT NOT NULL
);

INSERT INTO professors (professorusername, professorpassword, professordepartment, professorsalary) VALUES
    ('professor1', 'password1', 'department1', 1000),
    ('professor2', 'password2', 'department2', 2000),
    ('professor3', 'password3', 'department3', 4000),
    ('professor4', 'password4', 'department4', 5000),
    ('professor5', 'password5', 'department5', 6000);