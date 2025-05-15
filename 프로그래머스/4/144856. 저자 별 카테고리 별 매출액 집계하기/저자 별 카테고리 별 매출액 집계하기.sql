-- 코드를 입력하세요
SELECT a.author_id, c.author_name, a.category, sum(a.price * b.sales) as total_sales
from book a
join (select book_id, sum(sales) as sales
      from book_sales
      where sales_date like '2022-01%'
      group by book_id) b
on a.book_id = b.book_id
join author c
on a.author_id = c.author_id
group by a.author_id, c.author_name, a.category
order by a.author_id, a.category desc