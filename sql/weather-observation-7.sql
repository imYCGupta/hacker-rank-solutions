/*
Enter your query here.
*/
select distinct city from station where substring(city,length(city),length(city)) in ('a','i','e','o','u');