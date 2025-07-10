SELECT
    c.NAME Client_Name,
    COUNT(p.ID) Project_Count
FROM Client c
JOIN Project p ON c.ID = p.CLIENT_ID
GROUP BY c.ID, c.NAME
HAVING COUNT(p.ID) = (
    SELECT MAX(Project_Counts.Count)
    FROM (
        SELECT COUNT(ID) Count 
        FROM Project 
        GROUP BY CLIENT_ID
        ) Project_Counts);