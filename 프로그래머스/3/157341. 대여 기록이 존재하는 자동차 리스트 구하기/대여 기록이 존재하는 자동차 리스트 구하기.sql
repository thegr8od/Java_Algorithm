select distinct(a.car_id) as car_id
from car_rental_company_car a
join car_rental_company_rental_history b
on a.car_id = b.car_id
where a.car_type like '세단' and
    b.start_date like '2022-10%'
order by a.car_id desc