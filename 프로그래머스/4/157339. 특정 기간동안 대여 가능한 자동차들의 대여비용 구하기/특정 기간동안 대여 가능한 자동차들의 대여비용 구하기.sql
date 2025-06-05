select a.car_id, a.car_type, truncate(a.daily_fee*30*(1-b.discount_rate*0.01), 0) as fee
from car_rental_company_car a
join car_rental_company_discount_plan b
on a.car_type=b.car_type
where a.car_id not in (
    select c.car_id
    from car_rental_company_rental_history c
    where c.start_date <= '2022-11-30' and c.end_date >= '2022-11-01'
)
and a.car_type in ('SUV', '세단')
and b.duration_type = '30일 이상'
and a.daily_fee*30*(1-b.discount_rate*0.01) >= 500000
and a.daily_fee*30*(1-b.discount_rate*0.01)<2000000
order by fee desc, car_type asc, car_id desc;