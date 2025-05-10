-- 코드를 입력하세요
SELECT a.food_type, a.rest_id, a.rest_name, b.favorites
from rest_info a
join (select food_type, max(favorites) as favorites
     from rest_info
     group by food_type
     order by favorites) b
on a.food_type = b.food_type and a.favorites = b.favorites
order by food_type desc

