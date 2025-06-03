select b.score, a.emp_no, a.emp_name, a.position, a.email
from hr_employees a
join (select emp_no, sum(score) score
     from hr_grade
     group by emp_no
     order by sum(score) desc
     limit 1) b
on a.emp_no = b.emp_no