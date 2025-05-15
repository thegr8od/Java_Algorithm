-- 코드를 입력하세요
SELECT a.category, b.maxV as max_price, a.product_name
from food_product a
join (select category, max(price) as maxV
     from food_product
     where category like '과자' or
      category like '국' or category like '김치' or category like '식용유'
     group by category) b
on a.category = b.category and a.price = b.maxV
order by b.maxV desc