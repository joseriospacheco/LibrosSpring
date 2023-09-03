CREATE TABLE libros (
    id INT AUTO_INCREMENT ,
    titulo VARCHAR(255) NOT NULL,
    isbn VARCHAR(20) NOT NULL,
    stock INT NOT NULL,
    PRIMARY KEY(id)
);