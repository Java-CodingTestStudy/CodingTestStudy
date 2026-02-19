select
    mp.member_name, rr.review_text, DATE_FORMAT(rr.review_date, '%Y-%m-%d') AS REVIEW_DATE

from rest_review rr join member_profile mp on rr.member_id = mp.member_id


where rr.member_id = (select r.member_id
                      from rest_review r
                      group by r.member_id
                      order by count(member_id) desc
    limit 1)

order by rr.review_date, rr.review_text