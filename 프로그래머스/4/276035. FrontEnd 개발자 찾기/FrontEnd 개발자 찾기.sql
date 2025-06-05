select distinct a.id, a.email, a.first_name, a.last_name
from developers a
join skillcodes b
on b.code & a.skill_code
where b.category = 'Front End'
order by id asc