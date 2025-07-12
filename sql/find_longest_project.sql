SELECT DATEDIFF(
    MONTH, p.START_DATE, p.FINISH_DATE
    ) Project_Duration, c.NAME Client_Name
FROM Project p
JOIN Client c ON p.CLIENT_ID = c.ID
WHERE DATEDIFF(MONTH, p.START_DATE, p.FINISH_DATE) = (
    SELECT MAX(
        DATEDIFF(MONTH, START_DATE, FINISH_DATE)
        ) 
        FROM Project);