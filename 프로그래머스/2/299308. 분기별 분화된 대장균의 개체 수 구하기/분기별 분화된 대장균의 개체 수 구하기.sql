select a.quarter, count(a.quarter) as ecoli_count
from (select case
when month(differentiation_date) >= 1 and month(differentiation_date) <= 3 then '1Q'
when month(differentiation_date) >= 4 and month(differentiation_date) <= 6 then '2Q'
when month(differentiation_date) >= 7 and month(differentiation_date) <= 9 then '3Q'
when month(differentiation_date) >= 10 and month(differentiation_date) <= 12 then '4Q'
end as quarter
from ecoli_data) a
group by a.quarter
order by a.quarter