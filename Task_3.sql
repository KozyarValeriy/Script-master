/* Суммарные зарплатные выплаты для каждого из городов */

SELECT
	City,
	SUM(Salary)
FROM Employees
GROUP BY City;