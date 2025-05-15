-- 코드를 입력하세요
SELECT a.user_id, a.nickname, b.sales as total_sales
from used_goods_user a
join (select writer_id, sum(price) as sales
     from used_goods_board
     where status like 'DONE'
     group by writer_id
     having sum(price) >= 700000) b
on a.user_id = b.writer_id
order by b.sales
    