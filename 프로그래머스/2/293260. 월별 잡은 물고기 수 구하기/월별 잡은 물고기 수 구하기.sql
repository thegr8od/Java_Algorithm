select count(*) as fish_count, month(time) as month
from fish_info
group by month(time)
order by month(time)