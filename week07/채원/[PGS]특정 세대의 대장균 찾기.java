-- 코드를 작성해주세요

SELECT id -- 3세대
FROM ecoli_data
WHERE parent_id IN(

    SELECT id -- 2세대
    FROM ecoli_data
    WHERE parent_id IN(
        
        SELECT id -- 1세대
        FROM ecoli_data
        WHERE parent_id IS NULL
    
    )


)