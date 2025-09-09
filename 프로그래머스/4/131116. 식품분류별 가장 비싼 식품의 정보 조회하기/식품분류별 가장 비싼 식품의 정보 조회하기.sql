select a.category, b.max_price, a.product_name
from food_product a
join (select category, max(price) as max_price
     from food_product
     where category like '과자' or category like '국' or category like '김치' or category like '식용유'
     group by category) b
on a.price = b.max_price and a.category = b.category
order by b.max_price desc
