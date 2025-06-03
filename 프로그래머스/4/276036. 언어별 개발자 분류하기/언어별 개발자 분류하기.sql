# 프앤합 : 10256 파이썬 256 c# 1024 
# A : Front End 스킬과 Python 스킬을 함께 가지고 있는 개발자
# B : C# 스킬을 가진 개발자
# C : 그 외의 Front End 개발자

select 
case
    when skill_code & (select sum(code) from skillcodes where category like 'Front End') and skill_code & (select code from skillcodes where name like 'Python') then 'A'
    when skill_code & (select code from skillcodes where name like 'C#') then 'B'
    when skill_code & (select sum(code) from skillcodes where category like 'Front End') then 'C'
end as grade,
id, email
from developers a
group by grade,id,email
having grade is not null
order by grade, id