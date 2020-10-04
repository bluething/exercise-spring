DROP TABLE IF EXISTS user;

CREATE TABLE user (
	  id INT AUTO_INCREMENT  PRIMARY KEY,
	  username VARCHAR(48) NOT NULL,
	  password VARCHAR(48) NOT NULL
	);

INSERT INTO user(username, password) VALUES ('fulan', '123456');