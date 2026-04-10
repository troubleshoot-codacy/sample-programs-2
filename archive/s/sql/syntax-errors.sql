-- This file has SQL syntax errors that SQLint should catch

-- Missing FROM keyword
SELECT id, name users WHERE id = 1;

-- Unclosed parenthesis
SELECT * FROM users WHERE id IN (1, 2, 3;

-- Invalid keyword placement
SELECT id FROM WHERE users;

-- Missing comma between columns
SELECT id name email FROM users;

-- Unexpected token
SELECT * FROM users WHER id = 1;

-- Double FROM
SELECT id FROM FROM users;

-- Unterminated string literal
SELECT * FROM users WHERE name = 'unclosed;

-- Invalid GROUP BY usage
SELECT id, name FROM users GROUP;
