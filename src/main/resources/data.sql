-- Create the Leads table
CREATE TABLE Leads (
    id INT PRIMARY KEY AUTO_INCREMENT,
    firstName VARCHAR(50) NOT NULL,
    lastName VARCHAR(50) NOT NULL,
    address VARCHAR(100),
    city VARCHAR(50),
    zipCode VARCHAR(10),
    phoneNumber VARCHAR(15),
    emailAddress VARCHAR(100) UNIQUE NOT NULL
);

-- Create the Users table
CREATE TABLE Users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    state VARCHAR(50),
    court VARCHAR(100)
);

-- Create the Conversions table
CREATE TABLE Conversions (
    leadId INT,
    userId INT,
    FOREIGN KEY (leadId) REFERENCES Leads(id),
    FOREIGN KEY (userId) REFERENCES Users(id)
);

-- Insert sample data into the Leads table
INSERT INTO Leads (firstName, lastName, address, city, zipCode, phoneNumber, emailAddress)
VALUES
    ('John', 'Doe', '123 Main St', 'New York', '10001', '123-555-1234', 'john.doe@example.com'),
    ('Jane', 'Smith', '456 Oak Ave', 'Los Angeles', '90001', '456-555-5678', 'jane.smith@example.com');

-- Insert sample data into the Users table
INSERT INTO Users (state, court)
VALUES
    ('California', 'Superior Court');

-- Insert sample data into the Conversions table to link Leads and Users
INSERT INTO Conversions (leadId, userId)
VALUES
    (1, 1); -- Linking Lead with ID 1 to User with ID 1