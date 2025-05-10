-- 코드를 입력하세요
SELECT u.user_id, u.nickname, b.price as total_sales
from used_goods_user u
join (select writer_id, sum(price) as price
     from used_goods_board c
     where status like 'DONE'
     group by writer_id
     
     ) b
on u.user_id = b.writer_id
where b.price >= 700000
order by total_sales
