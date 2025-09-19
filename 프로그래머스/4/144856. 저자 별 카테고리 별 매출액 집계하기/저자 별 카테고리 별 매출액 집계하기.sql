select a.author_id, b.author_name, a.category, sum(price * sales) as total_sales
from book a
join author b
on a.author_id = b.author_id
join book_sales c
on a.book_id = c.book_id
where c.sales_date like '2022-01%'
group by a.author_id, a.category
order by a.author_id, a.category desc
