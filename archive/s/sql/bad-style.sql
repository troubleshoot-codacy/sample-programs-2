
-- AL01: implicit table alias (should use AS)
-- AL02: implicit column alias (should use AS)
-- CP01: inconsistent keyword casing (mix of upper/lower)
-- CP02: inconsistent identifier casing
-- LT01: spacing issues
-- LT02: indentation issues
-- LT04: trailing comma issues
-- RF01: reference to object not in FROM
-- ST01: unnecessary ELSE NULL
-- ST03: unused CTE
-- ST06: select targets order (complex expressions before simple columns)
-- ST07: USING instead of ON

select
    t.id,t.name,
    t.value as val
from orders t
where t.id>10;

-- Mixed keyword casing
SELECT id,name FROM users where id = 1;

-- Implicit table alias (AL01) and column alias (AL02)
select
    u.id,
    u.first_name || ' ' || u.last_name full_name,
    count(*) total
from users u
join orders o on u.id = o.user_id
group by u.id, u.first_name, u.last_name;

-- Unused CTE (ST03)
with unused_cte as (
    select 1 as val
),
active_users as (
    select id, name from users where active = true
)
select * from active_users;

-- ELSE NULL in CASE (ST01)
select
    id,
    case
        when status = 'active' then 'Active'
        when status = 'inactive' then 'Inactive'
        else null
    end as status_label
from users;

-- USING instead of explicit ON (ST07)
select *
from users
join orders using (user_id);

-- ST06: complex expression before simple column
select
    id,
    case when status = 1 then 'yes' else 'no' end as flag,
    name
from users;

-- Spacing issues (LT01)
select id ,name,  email from users where id=1 and name ='test';

-- Indentation issues (LT02)
select
id,
        name,
    email
from
users;

-- RF02: unqualified column in multi-table select
select
    id,
    name,
    order_date
from users u
join orders o on u.id = o.user_id;

-- AM01: DISTINCT with GROUP BY
select distinct
    department,
    count(*) as cnt
from employees
group by department;
