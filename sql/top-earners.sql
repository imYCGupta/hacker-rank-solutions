/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
with N1 As(select max(months*salary) as maxS from employee)select N1.maxS, count(e.name) from N1, employee e where e.salary = (N1.maxS / e.months) group by N1.maxS;