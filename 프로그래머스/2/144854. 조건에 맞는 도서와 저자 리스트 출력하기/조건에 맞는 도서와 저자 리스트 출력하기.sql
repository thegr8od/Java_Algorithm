-- 코드를 입력하세요
SELECT b.book_id, a.author_name, date_format(b.published_date, '%Y-%m-%d') as published_date
FROM author a
join (select author_id, published_date, book_id
     from book
     where category like '경제') b
on a.author_id = b.author_id     
order by b.published_date 