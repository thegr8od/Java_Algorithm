select a.cart_id
from (select cart_id, group_concat(name) as name
from cart_products
group by cart_id
      ) a
where name like '%Yogurt%' and name like '%Milk%'
order by a.cart_id