-- More SQLFluff rule triggers

-- LT12: file should end with single trailing newline (this file has extra)
-- LT13: file should not start with newlines (note the blank line above)

-- CV05: use IS NULL instead of = NULL
SELECT * FROM users WHERE email = NULL;

-- CV06: missing semicolon terminator
SELECT id, name FROM users

-- CV08: RIGHT JOIN should be LEFT JOIN
SELECT *
FROM orders
RIGHT JOIN users ON orders.user_id = users.id;

-- RF04: using keyword as identifier
SELECT select, from, where FROM table;

-- ST08: DISTINCT with parentheses
SELECT DISTINCT(name) FROM users;

-- Nested subquery in FROM (ST05)
SELECT *
FROM (
    SELECT id, name
    FROM users
    WHERE active = 1
) sub
WHERE sub.id > 10;

-- AM05: implicit join condition
SELECT *
FROM users, orders
WHERE users.id = orders.user_id;

-- LT09: multiple select targets on same line
SELECT id, name, email, created_at, updated_at FROM users;

-- CP03: inconsistent function casing
SELECT COUNT(*), count(*), Count(*) FROM users;

-- CP04: inconsistent boolean/null literal casing
SELECT * FROM users WHERE active = TRUE AND deleted = false AND middle_name IS null;

-- AM02: UNION without ALL/DISTINCT
SELECT id FROM users
UNION
SELECT id FROM admins;
