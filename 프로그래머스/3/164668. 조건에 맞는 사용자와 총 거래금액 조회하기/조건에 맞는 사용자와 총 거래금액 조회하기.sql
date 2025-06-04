select b.user_id, b.nickname, sum(price) as total_sales
from used_goods_board a
join used_goods_user b
on a.writer_id = b.user_id
where status like 'DONE'
group by a.writer_id
having sum(price) >= 700000
order by sum(price)