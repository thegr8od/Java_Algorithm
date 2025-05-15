-- 코드를 입력하세요
SELECT year(sales_date) as year, month(sales_date) as month, gender, count(distinct a.user_id) as users
from online_sale a
join (select user_id, gender
     from user_info
     where gender is not null
     ) b
on a.user_id = b.user_id
group by year(sales_date), month(sales_date), gender
order by year(sales_date),month(sales_date), gender