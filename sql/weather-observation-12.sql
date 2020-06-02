/*
Enter your query here.
*/
select distinct city from station where (
    substring(city,1,1) not in ('a','i','e','o','u') and 
    substring(city,length(city),length(city)) not in ('a','i','e','o','u')
);