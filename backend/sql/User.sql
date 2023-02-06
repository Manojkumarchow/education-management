create database education_management;

use education_management;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  category VARCHAR(100) NOT NULL,
  access_level varchar(10) DEFAULT NULL
);

INSERT INTO users (username, password, category, access_level) VALUES
  ('user1', 'password1', 'category1', '0'),
  ('user2', 'password2', 'category2', '0'),
  ('user3', 'password3', 'category3', '0'),
  ('user4', 'password4', 'category4', '0'),
  ('user5', 'password5', 'category5', '0');
INSERT INTO users (username, password, category, access_level) VALUES
  ('manoj', 'manoj', 'category1', '0');