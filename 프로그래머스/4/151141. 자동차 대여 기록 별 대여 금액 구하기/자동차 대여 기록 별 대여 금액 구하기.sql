select b.history_id, truncate(a.daily_fee * b.day * (1- ifnull(c.discount_rate, 0) * 0.01), 0) as fee
from car_rental_company_car a
join (select history_id, car_id, datediff(end_date, start_date)+1 as day, case
      when datediff(end_date, start_date)+1 >= 90 then '90일 이상'
      when datediff(end_date, start_date)+1 >= 30 then '30일 이상'
      when datediff(end_date, start_date)+1 >= 7 then '7일 이상'
      else null
      end as dif
from car_rental_company_rental_history) b
on a.car_id = b.car_id
left join car_rental_company_discount_plan c
on a.car_type = c.car_type and c.duration_type = b.dif
where a.car_type like '트럭'
order by fee desc, b.history_id desc
