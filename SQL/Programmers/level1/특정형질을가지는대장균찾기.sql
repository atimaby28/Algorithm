use programmers_db;

SELECT COUNT(ID) AS COUNT
FROM ECOLI_DATA                 -- Filter
WHERE (GENOTYPE & 5)            -- 5 = 0101
        AND NOT(GENOTYPE & 2)   -- 2 = 0010