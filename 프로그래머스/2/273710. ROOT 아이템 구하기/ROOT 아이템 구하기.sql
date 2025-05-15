-- 코드를 작성해주세요
select b.item_id, b.item_name
from item_info b
join item_tree a
on a.item_id = b.item_id
where a.parent_item_id is null