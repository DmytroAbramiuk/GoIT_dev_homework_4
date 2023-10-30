SELECT project_worker.project_id,
       SUM(workers.salary) * DATEDIFF(MONTH, projects.start_date, projects.finish_date) AS price
FROM project_worker
INNER JOIN workers ON project_worker.worker_id = workers.id
INNER JOIN projects ON project_worker.project_id = projects.id
GROUP BY project_worker.project_id, projects.start_date, projects.finish_date
ORDER BY price DESC;