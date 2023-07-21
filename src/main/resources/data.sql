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