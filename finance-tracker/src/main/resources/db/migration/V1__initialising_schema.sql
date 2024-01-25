CREATE TABLE "expenses" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255),
    price NUMERIC(10, 2),
    income VARCHAR(255),
    goal NUMERIC(10,2)
);
