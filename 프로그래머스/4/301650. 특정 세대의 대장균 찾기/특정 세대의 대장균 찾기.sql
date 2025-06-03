select d.id
from ecoli_data d
join (select b.id
from ecoli_data b
join (select id
from ecoli_data
where parent_id is null) a
on b.parent_id = a.id) c
on d.parent_id = c.id
order by d.id 