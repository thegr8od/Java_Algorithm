select h.flavor
from first_half h
join july j on h.flavor = j.flavor
group by flavor
order by sum(h.total_order) + sum(j.total_order) desc
limit 3