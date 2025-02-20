Hejsan! Välkommen till mitt projekt "biblotek". Om ni vill testa mitt projekt så är det konstruerat på det sättet att du som använder behöver veta:
 1 ditt användarnamn, 2 ditt användar id ,3 bok id till boken du vill låna/returnera.

 Du kommer kunna komma åt den här informationen i den textbaserade terminalen men du måste hålla reda på ditt eget id och bok id samt användarnamn.
 Böcker som är skappta och inlagda med "available" = "No" kommer inte kunna lånas.

 Mall för SQL databas med tables.

 CREATE DATABASE Biblotek;

CREATE TABLE books (books_id INT AUTO_INCREMENT PRIMARY KEY,
title VARCHAR (100) NOT NULL, 
author VARCHAR(100) NOT NULL,
available VARCHAR (100) NOT NULL);

DROP TABLE books;

CREATE TABLE customers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

DROP TABLE customers;


CREATE TABLE loans(loan_id INT AUTO_INCREMENT PRIMARY KEY,
user_name VARCHAR (100) NOT NULL, 
book_id INT,
customer_id INT,
loan_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
return_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 FOREIGN KEY (customer_id) REFERENCES customers(id),
  FOREIGN KEY (book_id) REFERENCES books(books_id)
);
DROP TABLE loans;


SELECT * FROM customers;
SELECT * FROM books;
SELECT * FROM loans;
