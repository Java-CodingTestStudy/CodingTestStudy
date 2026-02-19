SELECT ri.REST_ID, ri.REST_NAME, ri.FOOD_TYPE, ri.FAVORITES, ri.ADDRESS,
       ROUND(AVG(rr.REVIEW_SCORE),2) as SCORE
from rest_info ri
         join rest_review rr
              on ri.rest_id = rr.rest_id
where ADDRESS like '서울%'
group by REST_ID
order by ROUND(AVG(rr.REVIEW_SCORE),2) DESC, ri.FAVORITES desc