SELECT i.rest_id, rest_name, food_type, favorites, address, round(avg(r.review_score),2) as score
from rest_info i, rest_review r
where i.rest_id = r.rest_id
and i.address like '서울%'
group by rest_id
order by score desc, i.favorites desc;
