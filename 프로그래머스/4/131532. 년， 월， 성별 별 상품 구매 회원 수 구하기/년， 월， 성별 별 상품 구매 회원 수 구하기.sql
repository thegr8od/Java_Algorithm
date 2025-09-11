select year(a.sales_date) as year, month(a.sales_date) as month, b.gender, count(distinct a.user_id) as users
from online_sale a
join (select user_id, gender
     from user_info
     where gender is not null) b
on a.user_id = b.user_id
group by year(a.sales_date), month(a.sales_date), b.gender
order by year(a.sales_date), month(a.sales_date), b.gender