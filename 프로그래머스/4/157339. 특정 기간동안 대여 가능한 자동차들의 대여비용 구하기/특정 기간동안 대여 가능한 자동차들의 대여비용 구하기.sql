select a.car_id, a.car_type, truncate(a.daily_fee * (1-b.discount_rate * 0.01) * 30,0) as fee
from car_rental_company_car a
join car_rental_company_discount_plan b
on a.car_type = b.car_type
where a.car_id not in (select car_id
                      from car_rental_company_rental_history
                      where start_date <= '2022-11-30' and end_date >= '2022-11-01')
and (a.car_type like '세단' or a.car_type like 'SUV')
and b.duration_type like '30일 이상'
and a.daily_fee * (1-b.discount_rate * 0.01) * 30 >= 500000
and a.daily_fee * (1-b.discount_rate * 0.01) * 30 < 2000000
order by fee desc, a.car_type, a.car_id desc