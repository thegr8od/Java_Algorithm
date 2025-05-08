-- 코드를 작성해주세요
select i.item_id, i.item_name, i.rarity
from item_info i
left join item_tree t
on t.parent_item_id = i.item_id
where t.parent_item_id is null
order by i.item_id desc