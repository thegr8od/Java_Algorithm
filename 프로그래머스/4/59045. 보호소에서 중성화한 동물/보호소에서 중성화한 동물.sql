select a.animal_id, a.animal_type, a.name
from animal_ins a
join (select animal_id
     from animal_outs
     where sex_upon_outcome like 'Spayed%' or sex_upon_outcome like 'Neutered%') b
on a.animal_id = b.animal_id
where a.sex_upon_intake like 'Intact%'
order by animal_id