SELECT * FROM employees.dept_emp;
USE employees;

-- 현재 재직중인 직원
select * from dept_emp
where to_date = '9999-01-01';

-- 
use sakila;
select a.last_name, a.last_name, f.title
From film f
	inner join film_actor fa
    on f.film_id = fa.film_id
    inner join actor a
    on fa.actor_id = a.actor_id
order by f.title;

-- 
use employees;