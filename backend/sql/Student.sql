use education_management;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    studentname VARCHAR(100) NOT NULL,
    studentdepartment VARCHAR(100) NOT NULL
);

INSERT INTO students (studentname, studentdepartment) VALUES 
    ('student1', 'department1'),
    ('student2', 'department2'),
    ('student3', 'department3'),
    ('student4', 'department4'),
    ('student5', 'department5');