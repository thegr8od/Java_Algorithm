SELECT b.food_type, a.rest_id, a.rest_name, b.max as favorites
from rest_info a
join (select food_type, max(favorites) as max
     from rest_info
     group by food_type) b
on a.favorites = b.max and a.food_type = b.food_type
order by b.food_type desc
