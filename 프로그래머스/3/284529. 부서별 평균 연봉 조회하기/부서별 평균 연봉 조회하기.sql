-- 코드를 작성해주세요
select e.dept_id, d.dept_name_en,  round(avg(sal)) as avg_sal
from hr_employees e
join hr_department d
on e.dept_id = d.dept_id
group by dept_id
order by avg_sal desc