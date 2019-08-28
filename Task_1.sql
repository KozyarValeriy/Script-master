/* Записи о сотрудниках с уровнем оклада >= 1000 */
SELECT
	ID,
	Name,
	City,
	Salary
FROM Employees
WHERE Salary >= 1000;