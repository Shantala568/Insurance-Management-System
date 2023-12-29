create database insurances;
use insurances;

CREATE TABLE Policy (
    policyId INT PRIMARY KEY
);

CREATE TABLE User (
    userId INT PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    role VARCHAR(255)
);

CREATE TABLE Client (
    clientId INT PRIMARY KEY,
    clientName VARCHAR(255),
    contactInfo VARCHAR(255),
    policyId INT
);

ALTER TABLE Client
ADD FOREIGN KEY (policyId) REFERENCES Policy(policyId);

CREATE TABLE Claim (
    claimId INT PRIMARY KEY,
    claimNumber VARCHAR(255),
    dateFiled DATE,
    claimAmount DECIMAL(10,2),
    status VARCHAR(255),
    policyId INT,
    clientId INT
);

ALTER TABLE Claim
ADD FOREIGN KEY (policyId) REFERENCES Policy(policyId),
ADD FOREIGN KEY (clientId) REFERENCES Client(clientId);

CREATE TABLE Payment (
    paymentId INT PRIMARY KEY,
    paymentDate DATE,
    paymentAmount DECIMAL(10,2),
    clientId INT,
    FOREIGN KEY (clientId) REFERENCES Client(clientId)
);


ALTER TABLE Policy
ADD policyName VARCHAR(255),
ADD policyType VARCHAR(255),
ADD coverageAmount DECIMAL(10, 2);
