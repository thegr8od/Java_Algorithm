select b.id, b.genotype, a.genotype as parent_genotype
from ecoli_data a #부모
join ecoli_data b #자식 
on a.id = b.parent_id
where a.genotype & b.genotype = a.genotype
order by id asc