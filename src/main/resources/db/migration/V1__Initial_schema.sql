--Initial_schema.sql

CREATE TABLE customers (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE feedback (
    id SERIAL PRIMARY KEY,
    feedback_text TEXT NOT NULL,
    category VARCHAR(100),
    sentiment_score NUMERIC(3, 2),
    submission_date TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    customer_id INTEGER NOT NULL,
    CONSTRAINT fk_customer
        FOREIGN KEY(customer_id)
        REFERENCES customers(id)
);