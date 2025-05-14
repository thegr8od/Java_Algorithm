select case
when price >=0 and price <10000 then 0
when price>=10000 and price <20000 then 10000
when price>=20000 and price <30000 then 20000
when price>=30000 and price <40000 then 30000
when price>=40000 and price <50000 then 40000
when price>=50000 and price <60000 then 50000
when price>=60000 and price <70000 then 60000
when price>=70000 and price <80000 then 70000
when price>=80000 and price <90000 then 80000
end price_group, count(*) product
from product
group by price_group
order by price_group