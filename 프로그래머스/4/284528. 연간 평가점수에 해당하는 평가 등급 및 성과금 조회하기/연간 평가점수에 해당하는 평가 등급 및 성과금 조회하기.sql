select a.emp_no, a.emp_name, case
when b.avg >= 96 then 'S'
when b.avg >= 90 then 'A'
when b.avg >= 80 then 'B'
else 'C'
end as grade, 
case
when b.avg >= 96 then sal * 0.2
when b.avg >= 90 then sal * 0.15
when b.avg >= 80 then sal * 0.1
else 0
end as bonus
from hr_employees a
join (select emp_no, avg(score) as avg
     from hr_grade
     group by emp_no) b
on a.emp_no = b.emp_no
order by a.emp_no