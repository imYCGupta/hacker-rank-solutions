/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
select round(sum(lat_N),2) as lat, round(sum(long_w),2) as lon from station;