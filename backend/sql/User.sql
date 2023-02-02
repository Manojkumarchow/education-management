create database education_management;

use education_management;

CREATE TABLE Users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  category VARCHAR(100) NOT NULL
);

INSERT INTO Users (username, password, category) VALUES
  ('user1', 'password1', 'category1'),
  ('user2', 'password2', 'category2'),
  ('user3', 'password3', 'category3'),
  ('user4', 'password4', 'category4'),
  ('user5', 'password5', 'category5');
