/*
Enter your query here.
*/
(select city, length(city) from station group by city order by length(city) asc, city asc limit 1)
union all
(select city, length(city) from station group by city order by length(city) desc, city asc limit 1);