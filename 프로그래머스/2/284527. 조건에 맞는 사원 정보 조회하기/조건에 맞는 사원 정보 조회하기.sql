select sum(g.score) as score, e.emp_no, e.emp_name, e.position, e.email
from hr_employees e
join hr_grade g on e.emp_no = g.emp_no
group by g.emp_no, g.year
having year like '2022'
order by score desc
limit 1