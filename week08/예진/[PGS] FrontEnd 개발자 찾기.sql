-- Front End 스킬을 가진 개발자의 ID, 이메일, 이름, 성 을 조회
-- ID 기준 오름차순
SELECT DISTINCT
       dev.id
     , dev.email
     , dev.first_name
     , dev.last_name
  FROM developers dev
  JOIN skillcodes skill 
    ON (dev.skill_code & skill.code) != 0
   AND skill.category = 'Front End'
 ORDER BY dev.id