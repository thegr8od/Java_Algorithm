select a.flavor
from (select flavor, sum(total_order) as asum
     from first_half
     group by flavor) a
join (select flavor, sum(total_order) as bsum
     from july
     group by flavor) b
on a.flavor = b.flavor
order by asum + bsum desc
limit 3