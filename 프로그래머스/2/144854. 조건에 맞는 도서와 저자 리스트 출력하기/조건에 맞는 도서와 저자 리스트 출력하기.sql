-- 코드를 입력하세요
SELECT a.book_id, b.author_name, date_format(a.published_date, '%Y-%m-%d') as published_date
from book a
join author b
on a.author_id = b.author_id
where a.category like '경제'
order by a.published_date