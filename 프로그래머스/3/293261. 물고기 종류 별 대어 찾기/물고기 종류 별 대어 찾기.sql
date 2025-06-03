select f.id, b.fish_name, f.length
from fish_info f
join (select a.fish_type, max(length) as maxV
from fish_info a
group by fish_type) c
on f.fish_type = c.fish_type and f.length = c.maxV
join fish_name_info b
on f.fish_type = b.fish_type
order by f.id