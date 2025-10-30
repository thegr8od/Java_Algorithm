select b.emp_no, b.emp_name, case
when a.aver >= 96 then 'S'
when a.aver >= 90 then 'A'
when a.aver >= 80 then 'B'
else 'C' end as grade, case
when a.aver >= 96 then b.sal * 0.2
when a.aver >= 90 then b.sal * 0.15
when a.aver >= 80 then b.sal * 0.1
else 0 end as bonus
from (select emp_no, avg(score) as aver
     from hr_grade
     group by emp_no) a
join hr_employees b
on a.emp_no = b.emp_no
order by b.emp_no