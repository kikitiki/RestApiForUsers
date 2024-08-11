DROP TABLE IF EXISTS app_user;
DROP TABLE IF EXISTS account;


CREATE TABLE app_user (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE account (
    id BIGINT IDENTITY(1,1) PRIMARY KEY,
    account_number VARCHAR(255) NOT NULL,
    balance DECIMAL(18, 2) NOT NULL,
    user_id BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES app_user(id)
);
