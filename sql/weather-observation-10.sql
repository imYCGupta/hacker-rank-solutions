/*
Enter your query here.
*/
select distinct city from station where substring(city,length(city),length(city)) not in ('a','i','e','o','u');