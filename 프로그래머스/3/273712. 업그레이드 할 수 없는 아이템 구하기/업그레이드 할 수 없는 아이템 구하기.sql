select a.item_id, a.item_name, a.rarity
from item_info a
where a.item_id not in (select parent_item_id
     from item_tree
     where parent_item_id is not null) 
order by a.item_id desc