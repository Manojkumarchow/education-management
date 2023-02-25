use education_management;

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    studentname VARCHAR(100) NOT NULL,
    studentpassword VARCHAR(100) NOT NULL,
    studentdepartment VARCHAR(100) NOT NULL
);

INSERT INTO students (studentname, studentpassword, studentdepartment) VALUES 
    ('student1', 'password1', 'department1'),
    ('student2', 'password2', 'department2'),
    ('student3', 'password3', 'department3'),
    ('student4', 'password4', 'department4'),
    ('student5', 'password5', 'department5');