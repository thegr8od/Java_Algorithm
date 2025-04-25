select count(*) as fish_count, fish_name
from fish_name_info n
join fish_info i
on i.fish_type = n.fish_type
group by n.fish_name
order by fish_count desc;