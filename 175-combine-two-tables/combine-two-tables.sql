# Write your MySQL query statement below
SELECT Person.firstName,person.lastName,Address.city,Address.state
FROM person
LEFT JOIN address ON person.personId = Address.personId;