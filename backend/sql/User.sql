create database education_management;

use education_management;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  access_level varchar(10) DEFAULT NULL,
  security_question VARCHAR(100) NOT NULL,
  security_answer VARCHAR(100) NOT NULL
);

INSERT INTO users (username, password, access_level, security_question, security_answer) VALUES
  ('user1', 'password1', '0', '1', 'answer1'),
  ('user2', 'password2', '0', '2', 'answer2'),
  ('user3', 'password3', '0', '3', 'answer3'),
  ('user4', 'password4', '0', '1', 'answer4'),
  ('user5', 'password5', '0', '2', 'answer5');
INSERT INTO users (username, password, access_level) VALUES
  ('manoj', 'manoj', '0');