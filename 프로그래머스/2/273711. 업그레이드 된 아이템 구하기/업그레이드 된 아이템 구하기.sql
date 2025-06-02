select a.item_id, a.item_name, a.rarity
from item_info a
join (select item_id
     from item_tree
     where parent_item_id in (select item_id
                             from item_info
                             where rarity like 'RARE')) b
on a.item_id = b.item_id
order by a.item_id desc