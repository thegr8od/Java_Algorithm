select distinct(a.cart_id)
from cart_products a
join (select cart_id
     from cart_products b
     where name like 'Yogurt') b
on a.cart_id = b.cart_id
where a.name like 'Milk'
order by a.cart_id