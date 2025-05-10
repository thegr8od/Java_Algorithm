-- 코드를 입력하세요
SELECT category, sum(sales) as total_sales
from book b
join (select book_id, sum(sales) as sales
     from book_sales
     where sales_date like '2022-01%'
     group by book_id) i
on b.book_id = i.book_id
group by category
order by category



#경제 357, 인문 180, 소설 161, 기술 444, 생활 226