select a.id, a.email, a.first_name, a.last_name
from developers a
where skill_code & (select code
      from skillcodes 
      where name like 'C#') = (select code
      from skillcodes 
      where name like 'C#') or
      skill_code & (select code
      from skillcodes 
      where name like 'Python') = (select code
      from skillcodes 
      where name like 'Python')
order by id
     