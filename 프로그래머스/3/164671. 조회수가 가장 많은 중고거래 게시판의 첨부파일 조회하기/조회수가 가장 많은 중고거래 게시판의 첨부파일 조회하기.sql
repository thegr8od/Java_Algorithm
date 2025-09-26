select concat('/home/grep/src/', a.board_id, '/' , b.file_id, b.file_name, b.file_ext) as file_path
from (select board_id
     from used_goods_board
     order by views desc
     limit 1 ) a
join used_goods_file b
on a.board_id = b.board_id
order by file_path desc
     