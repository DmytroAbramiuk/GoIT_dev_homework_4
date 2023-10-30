SELECT clients."name", COUNT(projects.client_id) AS PROJECT_COUNT
FROM clients
JOIN projects ON clients.id = projects.client_id
GROUP BY clients.id, clients."name"
HAVING COUNT(projects.client_id) = (
	SELECT MAX(project_count)
	FROM(
		SELECT COUNT(client_id) AS project_count
		FROM projects
		GROUP BY client_id
	) AS project_counts
)