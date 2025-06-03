-- 코드를 입력하세요
SELECT a.category, sum(b.sum) as total_sales
from book a
join (select book_id, sum(sales) as sum
     from book_sales
     where date_format(sales_date, '%Y-%m') = '2022-01'
     group by book_id) b
on a.book_id = b.book_id
group by a.category
order by a.category 