/* Список сотрудников, которые работают не в одиночку (т. е. Если 
в одном городе работает больше 1 сотрудника) и зарабатывающих 
более 500 единиц каждый
*/

SELECT
	Name,
	City,
	Salary
FROM(
	SELECT
		Name,
		City,
		Salary,
		COUNT(City) OVER (PARTITION BY City) AS num
	FROM Employees
	WHERE Salary > 500)
WHERE num > 1;