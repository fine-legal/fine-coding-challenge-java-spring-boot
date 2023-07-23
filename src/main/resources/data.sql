-- Create the leads table
CREATE TABLE leads (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    address VARCHAR(100),
    city VARCHAR(50),
    zip_code VARCHAR(10),
    phone_number VARCHAR(15),
    email_address VARCHAR(100) UNIQUE NOT NULL
);

-- Create the users table
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    address VARCHAR(100),
    city VARCHAR(50),
    zip_code VARCHAR(10),
    phone_number VARCHAR(15),
    email_address VARCHAR(100) UNIQUE NOT NULL,
    state VARCHAR(50),
    court VARCHAR(100)
);

-- Insert sample data into the leads table
INSERT INTO leads (first_name, last_name, address, city, zip_code, phone_number, email_address)
VALUES
    ('John', 'Doe', '123 Main St', 'New York', '10001', '123-555-1234', 'john.doe@example.com'),
    ('Jane', 'Smith', '456 Oak Ave', 'Los Angeles', '90001', '456-555-5678', 'jane.smith@example.com');

-- Insert sample data into the users table
INSERT INTO users (first_name, last_name, address, city, zip_code, phone_number, email_address, state, court)
VALUES
    ('Julian', 'Autobahn', '222 Second Rd', 'San Diego', '90001', '111-555-1111', 'julian@autobahn.com', 'California', 'Low Court');
