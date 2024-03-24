USE programmers_db;

CREATE TABLE BOOK
(
	BOOK_ID			INTEGER NOT NULL,
    CATEGORY 		VARCHAR(255) NOT NULL,
    AUTHOR_ID		INTEGER NOT NULL,
    PRICE 			INTEGER NOT NULL,
    PUBLISHED_DATE 	DATE NOT NULL
);


INSERT INTO BOOK(book_id, category, author_id, price, published_date) VALUES (1,	"경제",	1,	9000,	"2020-01-10 00:00:00");
INSERT INTO BOOK(book_id, category, author_id, price, published_date) VALUES (2,	"경제",	1,	12000,	"2021-06-10 00:00:00");
INSERT INTO BOOK(book_id, category, author_id, price, published_date) VALUES (3,	"인문",	1,	11000,	"2021-10-24 00:00:00");
INSERT INTO BOOK(book_id, category, author_id, price, published_date) VALUES (4,	"소설",	2,	7500,	"2020-03-03 00:00:00");
INSERT INTO BOOK(book_id, category, author_id, price, published_date) VALUES (5,	"기술",	3,	11000,	"2020-02-17 00:00:00");
INSERT INTO BOOK(book_id, category, author_id, price, published_date) VALUES (6,	"기술",	3,	8000,	"2020-04-29 00:00:00");
INSERT INTO BOOK(book_id, category, author_id, price, published_date) VALUES (7,	"생활",	3,	9500,	"2021-08-20 00:00:00");

     