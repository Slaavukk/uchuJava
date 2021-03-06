CREATE DATABASE shop;
    CREATE TABLE orderStatus (
    id INT,
    status VARCHAR(20) NOT NULL UNIQUE,
    PRIMARY KEY (id)
    );
    INSERT INTO orderStatus (id, status)
    values
    (1, 'CREATED'),
    (2, 'DELIVERY'),
    (3, 'CLOSED');

    CREATE TABLE role (
    id INT,
    roles VARCHAR(20) NOT NULL UNIQUE,
    PRIMARY KEY (id)
    );
    INSERT INTO role (id, roles)
    values
    (1, 'ADMIN'),
    (2, 'CUSTOMER'),
    (3, 'SALESMAN');

    CREATE TABLE users (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(30),
    lastname VARCHAR(30),
    birthday DATE,
    mail VARCHAR(40),
    password VARCHAR(32),
    role INT NOT NULL DEFAULT 1,
    basket_id INT NOT NULL DEFAULT 1,
    CONSTRAINT fk_user_role FOREIGN KEY (role) REFERENCES role (id),
    PRIMARY KEY(id)
    );
    CREATE TABLE product (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(40),
    price INT,
    number INT,
    PRIMARY KEY (id)
    );
    CREATE TABLE reviews (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    text TEXT,
    product_id INT REFERENCES product (id),
    user_id INT REFERENCES users (id),
    PRIMARY KEY (id)
    );
    CREATE TABLE orders (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    status INT NOT NULL DEFAULT 1,
    CONSTRAINT fk_user_orderStatus FOREIGN KEY (status) REFERENCES orderStatus(id),
    user_id INT REFERENCES users (id),
    PRIMARY KEY (id)
    );
    CREATE TABLE basket (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    user_id INT UNIQUE REFERENCES users (id),
    PRIMARY KEY (id)
    );

    CREATE TABLE order_product (
    order_id INT REFERENCES orders (id),
    product_id INT REFERENCES product (id),
    PRIMARY KEY (order_id, product_id)
    );
    CREATE TABLE basket_product (
    basket_id INT REFERENCES basket (id),
    product_id INT REFERENCES product (id),
    PRIMARY KEY (basket_id, product_id)
    );
    CREATE TABLE users_role (
    users_id INT REFERENCES users(id),
    role_id INT REFERENCES role(id)
    )

