CREATE DATABASE chatbot_db;

USE chatbot_db;

CREATE TABLE chatbot_responses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_message VARCHAR(255) NOT NULL,
    response VARCHAR(255) NOT NULL
);

INSERT INTO chatbot_responses (user_message, response) VALUES
('Hello', 'Hi there! How can I help you?'),
('What is your name?', 'I am a chatbot created to assist you.'),
('Help', 'Sure! What do you need help with?');