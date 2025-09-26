select cart_id
from (select cart_id, group_concat(name) as gn
     from cart_products
     group by cart_id) b
where b.gn like '%Milk%' and b.gn like '%Yogurt%'
order by cart_id 