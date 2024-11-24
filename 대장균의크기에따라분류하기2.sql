use programmers_db;

-- 코드를 작성해주세요
SELECT 
    ID,
    CASE 
        WHEN RANK = 1 THEN 'CRITICAL'
        WHEN RANK = 2 THEN 'HIGH'
        WHEN RANK = 3 THEN 'MEDIUM'
        ELSE 'LOW'
    END AS COLONY_NAME
FROM (
    SELECT 
        ID, 
        NTILE(4) OVER (ORDER BY SIZE_OF_COLONY DESC) AS RANK
    FROM ECOLI_DATA
) AS SUBQUERY
ORDER BY ID;
