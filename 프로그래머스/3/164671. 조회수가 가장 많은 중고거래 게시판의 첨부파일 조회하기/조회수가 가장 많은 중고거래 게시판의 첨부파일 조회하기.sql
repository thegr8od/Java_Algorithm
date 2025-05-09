-- 코드를 입력하세요
SELECT distinct concat(concat(concat(concat(concat('/home/grep/src/', f.board_id),'/'), f.file_id), f.file_name),f.file_ext) as file_path
from used_goods_file f
join used_goods_board b 
on f.board_id = (select b.board_id
                from used_goods_board b
                order by b.views desc
                limit 1)
order by f.file_id desc