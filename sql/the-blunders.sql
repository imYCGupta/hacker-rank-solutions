/*
Enter your query here.
*/
select ceil(
    (select avg(salary) from employees) 
                      - 
    (select avg(replace(salary,0,'')) from employees)
);