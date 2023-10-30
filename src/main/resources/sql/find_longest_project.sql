SELECT id, DATEDIFF(MONTH, start_date, finish_date) AS duration_months
FROM projects
WHERE DATEDIFF(MONTH, start_date, finish_date) = (
    SELECT MAX(DATEDIFF(MONTH, start_date, finish_date))
    FROM projects
);