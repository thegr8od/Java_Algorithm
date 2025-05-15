-- 코드를 입력하세요
SELECT a.category, sum(b.sales) as total_sales
from book a
join (select book_id, sum(sales) as sales
     from book_sales
     where sales_date like '2022-01%'
     group by book_id) b
on a.book_id = b.book_id
group by a.category
order by a.category