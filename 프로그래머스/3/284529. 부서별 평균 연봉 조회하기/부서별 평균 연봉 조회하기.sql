select a.dept_id, b.dept_name_en, round(avg(sal), 0) as avg_sal
from hr_employees a
join hr_department b
on a.dept_id = b.dept_id
group by a.dept_id
order by avg_sal desc