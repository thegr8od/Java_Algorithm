-- 코드를 입력하세요
select b.user_id, b.nickname, concat(city, ' ', street_address1,' ', street_address2) as '전체주소',
    concat(substring(tlno, 1, 3), '-', substring(tlno, 4,4), '-', substring(tlno, 8,4) ) as '전화번호'
from (select writer_id
     from used_goods_board
     group by writer_id
     having count(writer_id) >= 3) a
join used_goods_user b
on a.writer_id = b.user_id
order by b.user_id desc