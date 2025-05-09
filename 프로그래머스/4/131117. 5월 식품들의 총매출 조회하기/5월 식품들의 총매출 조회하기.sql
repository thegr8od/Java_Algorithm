select a.product_id, b.product_name, sum(b.price * a.amount) as total_sales
from food_order a
join (select * from food_product) b
on a.product_id = b.product_id
where a.produce_date like '2022-05%'
group by a.product_id
order by total_sales desc, b.product_id asc;