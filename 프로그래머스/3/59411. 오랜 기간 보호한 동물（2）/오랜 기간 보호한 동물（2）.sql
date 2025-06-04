select a.animal_id, a.name
from animal_ins a
join animal_outs b
on a.animal_id = b.animal_id
order by datediff(b.datetime, a.datetime) desc
limit 2
