select a.year, a.month, b.gender as gender, count(*) as users
from (select user_id, year(sales_date) as year, month(sales_date) as month
      from online_sale
      group by user_id, year(sales_date), month(sales_date)
      ) a
join user_info b
on a.user_id = b.user_id
where gender is not null
group by a.year, a.month, b.gender
order by year,month,gender