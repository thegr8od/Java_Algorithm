select year(differentiation_date) as year, abs(a.size_of_colony - b.maxV) as year_dev, id
from ecoli_data a
join (select year(differentiation_date) as year, max(size_of_colony) as maxV
     from ecoli_data
     group by year(differentiation_date)) b
on year(a.differentiation_date) = b.year
order by year(differentiation_date), year_dev