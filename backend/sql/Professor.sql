-- create database education_management;

use education_management;

CREATE TABLE Professors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    professorUsername VARCHAR(100) NOT NULL,
    professorPassword VARCHAR(100) NOT NULL,
    professorDepartment VARCHAR(100) NOT NULL,
    professorSalary INT NOT NULL
);

INSERT INTO Professors (professorUsername, professorPassword, professorDepartment, professorSalary) VALUES
    ('professor1', 'password1', 'department1', 1000),
    ('professor2', 'password2', 'department2', 2000),
    ('professor3', 'password3', 'department3', 4000),
    ('professor4', 'password4', 'department4', 5000),
    ('professor5', 'password5', 'department5', 6000);