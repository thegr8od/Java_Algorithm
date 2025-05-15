-- 코드를 입력하세요
SELECT a.product_id, a.product_name, a.product_cd, a.category, a.price
from food_product a
join (select max(price) as price
     from food_product
     ) b
where a.price = b.price