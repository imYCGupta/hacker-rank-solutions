/*
Enter your query here.
*/
select distinct city from station where substring(city,1,1) in ('a','i','e','o','u');