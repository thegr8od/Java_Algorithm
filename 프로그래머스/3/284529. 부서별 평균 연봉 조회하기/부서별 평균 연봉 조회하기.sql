select a.dept_id, a.dept_name_en, round(b.sal) as avg_sal
from hr_department a
join (select dept_id, avg(sal) as sal
     from hr_employees
     group by dept_id) b
on a.dept_id = b.dept_id
order by round(b.sal) desc