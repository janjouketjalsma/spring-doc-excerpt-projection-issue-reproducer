-- Books
INSERT INTO book (id, title, description) VALUES (1, 'Hello', 'Hello description');
INSERT INTO book (id, title, description) VALUES (2, 'World', 'World description');

-- Book stores
INSERT INTO book_store (id, name) VALUES (1, 'Store');

-- Book store books
INSERT INTO book_store_books (book_store_id, books_id) VALUES (1, 1);
INSERT INTO book_store_books (book_store_id, books_id) VALUES (1, 2);
