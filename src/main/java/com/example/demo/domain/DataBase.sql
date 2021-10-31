CREATE DATABASE shop;
    CREATE TABLE orderStatus (
    status_id INT,
    status VARCHAR(20) NOT NULL UNIQUE,
    PRIMARY KEY (status_id)
    );
    INSERT INTO orderStatus (status_id, status)
    values
    (1, 'CREATED'),
    (2, 'DELIVERY'),
    (3, 'CLOSED');

    CREATE TABLE role (
    role_id INT,
    role VARCHAR(20) NOT NULL UNIQUE,
    PRIMARY KEY (role_id)
    );
    INSERT INTO role (role_id, role)
    values
    (1, 'ADMIN'),
    (2, 'CUSTOMER'),
    (3, 'SALESMAN');

    CREATE TABLE user (
    user_id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(30),
    lastname VARCHAR(30),
    birthday DATE,
    mail VARCHAR(40),
    password VARCHAR(32),
    role INT NOT NULL DEFAULT 1,
    status INT NOT NULL DEFAULT 1,
    CONSTRAINT fk_user_role FOREIGN KEY (role) REFERENCES role (role_id),
    CONSTRAINT fk_user_orderStatus FOREIGN KEY (status) REFERENCES orderStatus(status_id),
    PRIMARY KEY(user_id)
    );
    CREATE TABLE product (
    product_id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    name VARCHAR(40),
    price INT,
    number INT,
    PRIMARY KEY (product_id)
    );
    CREATE TABLE reviews (
    review_id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    text TEXT,
    product_id INT REFERENCES product (product_id),
    user_id INT REFERENCES user (user_id),
    PRIMARY KEY (review_id)
    );
    CREATE TABLE order (
    order_id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    user_id INT REFERENCES user (user_id),
    PRIMARY KEY (order_id)
    );
    CREATE TABLE basket (
    basket_id INT NOT NULL GENERATED ALWAYS AS IDENTITY,
    user_id INT UNIQUE REFERENCES user (user_id),
    PRIMARY KEY (basket_id)
    );

    CREATE TABLE order_product (
    order_id INT REFERENCES order (order_id),
    product_id INT REFERENCES product (product_id),
    PRIMARY KEY (order_id, product_id)
    );
    CREATE TABLE basket_product (
    basket_id INT REFERENCES basket (basket_id),
    product_id INT REFERENCES product (product_id),
    PRIMARY KEY (basket_id, product_id)
    );

