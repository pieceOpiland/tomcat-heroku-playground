CREATE TABLE MyInt (
  id        SERIAL PRIMARY KEY,
  value     INT NOT NULL
);

CREATE TABLE todo_item (
  id        SERIAL PRIMARY KEY,
  is_done   BOOLEAN,
  task      VARCHAR(256),
  created   TIMESTAMP DEFAULT now()
);