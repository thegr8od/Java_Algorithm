select c.id, b.fish_name, a.length
from (select fish_type, max(length) as length
     from fish_info
     group by fish_type) a
join fish_name_info b
on a.fish_type = b.fish_type
join fish_info c
on a.length = c.length and a.fish_type = c.fish_type
order by c.id 