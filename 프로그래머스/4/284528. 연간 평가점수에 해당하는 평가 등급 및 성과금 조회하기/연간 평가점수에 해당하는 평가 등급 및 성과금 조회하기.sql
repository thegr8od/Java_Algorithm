select a.emp_no, a.emp_name, b.grade, case
when b.grade like 'S' then a.sal * 0.2
when b.grade like 'A' then a.sal * 0.15
when b.grade like 'B' then a.sal * 0.1
else 0
end as bonus
from hr_employees a
join (select emp_no, case
when avg(score) >= 96 then 'S'
when avg(score) >= 90 then 'A'
when avg(score) >= 80 then 'B'
else 'C' end as grade
from hr_grade
group by emp_no) b
on a.emp_no = b.emp_no
order by emp_no