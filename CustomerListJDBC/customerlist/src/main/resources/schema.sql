CREATE TABLE IF NOT EXISTS customer (
    customer_id int(5) NOT NULL AUTO_INCREMENT,
    firstname varchar(50) DEFAULT NULL,
    lastname varchar(50) DEFAULT NULL,
    PRIMARY KEY(customer_id)
    );