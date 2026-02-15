-- 코드를 입력하세요
SELECT flavor
FROM (
    SELECT fh.flavor,fh.total_order + j.july_order AS sum_order
    FROM first_half fh
    JOIN (
        SELECT flavor, SUM(total_order) AS july_order
        FROM july
        GROUP BY flavor
    ) j
      ON fh.flavor = j.flavor ORDER BY sum_order DESC
)
WHERE ROWNUM <= 3;