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
    state VARCHAR(50),
    court VARCHAR(100)
);

-- Create the conversions table
CREATE TABLE conversions (
    lead_id INT,
    user_id INT,
    FOREIGN KEY (lead_id) REFERENCES leads(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

-- Insert sample data into the leads table
INSERT INTO leads (first_name, last_name, address, city, zip_code, phone_number, email_address)
VALUES
    ('John', 'Doe', '123 Main St', 'New York', '10001', '123-555-1234', 'john.doe@example.com'),
    ('Jane', 'Smith', '456 Oak Ave', 'Los Angeles', '90001', '456-555-5678', 'jane.smith@example.com');

-- Insert sample data into the users table
INSERT INTO users (state, court)
VALUES
    ('California', 'Superior Court');

-- Insert sample data into the conversions table to link leads and users
INSERT INTO conversions (lead_id, user_id)
VALUES
    (1, 1); -- Linking lead with ID 1 to user with ID 1