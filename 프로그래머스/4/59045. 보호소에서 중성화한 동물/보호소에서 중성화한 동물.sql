-- 코드를 입력하세요
SELECT o.animal_id, o.animal_type, o.name
from animal_outs o
join animal_ins i
on i.animal_id = o.animal_id
where i.sex_upon_intake not like 'Spayed%' and
i.sex_upon_intake not like 'Neutered%'
AND (o.sex_upon_outcome LIKE 'Spayed%' OR o.sex_upon_outcome LIKE 'Neutered%')
order by o.animal_id