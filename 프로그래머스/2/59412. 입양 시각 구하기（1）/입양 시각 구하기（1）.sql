-- 코드를 입력하세요
SELECT hour(datetime) as HOUR, count(datetime) as COUNT
from animal_outs
group by hour(datetime)
having hour >=9 and hour <= 19
order by hour(datetime)