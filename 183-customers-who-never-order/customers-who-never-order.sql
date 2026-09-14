# Write your MySQL query statement 
SELECT name as customers
from customers
where id not in (select customerId from Orders);

