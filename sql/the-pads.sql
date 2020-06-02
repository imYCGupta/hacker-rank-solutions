/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
select concat(name,concat('(',concat(substr(occupation,1,1),')'))) from OCCUPATIONS order by name asc;
select concat('There are a total of ',concat(count(name), concat(concat(' ',lower(occupation)),'s.'))) from occupations group by occupation order by count(name) asc, occupation asc;