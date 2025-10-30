select a.item_id, a.item_name, a.rarity
from item_info a
join item_tree b
on a.item_id = b.item_id
left join item_tree c
on a.item_id = c.parent_item_id
where c.parent_item_id is null
order by item_id desc