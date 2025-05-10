-- 코드를 입력하세요
SELECT distinct c.car_id
from car_rental_company_car c
join car_rental_company_rental_history h
on c.car_id = h.car_id
where h.start_date like '2022-10%' and car_type like '세단'
order by c.car_id desc