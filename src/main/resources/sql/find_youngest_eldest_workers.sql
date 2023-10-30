SELECT  'YOUNGEST' AS TYPE,"name", birthday
FROM workers
WHERE DATEDIFF(YEAR, birthday, NOW()) = (
    SELECT MIN(DATEDIFF(YEAR, birthday, NOW()))
    FROM workers
)
UNION
SELECT 'ELDEST' AS TYPE, "name", birthday
FROM workers
WHERE DATEDIFF(YEAR, birthday, NOW()) = (
    SELECT MAX(DATEDIFF(YEAR, birthday, NOW()))
    FROM workers
);