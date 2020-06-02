/*
Enter your query here.
Please append a semicolon ";" at the end of the query and enter your query in a single line to avoid error.
*/
with N1 as(
    select min(lat_n) as a, 
    max(lat_n) as b, 
    min(long_w) as c, 
    max(long_w) as d from station
), 
N2 as(
    select (N1.b-N1.a) as x,
    (N1.d-N1.c) as y from N1
)select round(x+y,4) from N2;