-- 각 세대별 자식이 없는 개체의 수(COUNT)와 세대(GENERATION)를 출력
-- 세대 기준 오름차순
WITH RECURSIVE gen AS (
    SELECT id, parent_id, 1 AS level
      FROM ecoli_data 
     WHERE parent_id IS NULL
     
     UNION ALL
     
    SELECT child.id, child.parent_id, g.level + 1
      FROM ecoli_data child
      JOIN gen g
        ON g.id = child.parent_id
)

SELECT COUNT(*) AS count
     , g.level AS generation
  FROM gen g
  LEFT JOIN ecoli_data child
    ON g.id = child.parent_id
 WHERE child.id IS NULL
 GROUP BY g.level
 ORDER BY g.level