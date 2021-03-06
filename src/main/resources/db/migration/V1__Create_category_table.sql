-- Table: category

CREATE TABLE category
(
    category_id BIGSERIAL,
    name        VARCHAR(25) NOT NULL,
    last_update TIMESTAMP,
    CONSTRAINT category_pk PRIMARY KEY (category_id)

);

INSERT INTO category (name, last_update)
VALUES ('Action', '2006-02-15 09:46:27'),
       ('Animation', '2006-02-15 09:46:27'),
       ('Children', '2006-02-15 09:46:27'),
       ('Classics', '2006-02-15 09:46:27'),
       ('Comedy', '2006-02-15 09:46:27'),
       ('Documentary', '2006-02-15 09:46:27'),
       ('Drama', '2006-02-15 09:46:27'),
       ('Family', '2006-02-15 09:46:27'),
       ('Foreign', '2006-02-15 09:46:27'),
       ('Games', '2006-02-15 09:46:27'),
       ('Horror', '2006-02-15 09:46:27'),
       ('Music', '2006-02-15 09:46:27'),
       ('New', '2006-02-15 09:46:27'),
       ('Sci-Fi', '2006-02-15 09:46:27'),
       ('Sports', '2006-02-15 09:46:27'),
       ('Travel', '2006-02-15 09:46:27');

