-- 코드를 입력하세요
SELECT u.user_id, u.nickname, concat(city, " ", street_address1, " ", street_address2) as '전체주소',
    concat(substr(tlno,1,3), '-', substr(tlno,4,4), '-', substr(tlno,8,4)) as tlno
from used_goods_user u
join (select writer_id
      from used_goods_board
      group by writer_id
      having count(writer_id) >= 3) b
on u.user_id = b.writer_id
order by u.user_id desc