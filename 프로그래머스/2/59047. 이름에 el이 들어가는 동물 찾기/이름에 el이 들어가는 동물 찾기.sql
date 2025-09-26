select animal_id, name
from animal_ins
where name regexp 'el' and animal_type like 'dog'
order by name