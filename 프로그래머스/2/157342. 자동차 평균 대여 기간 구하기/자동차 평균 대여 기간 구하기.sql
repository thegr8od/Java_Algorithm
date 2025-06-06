select car_id, round(avg(datediff(end_date, start_date)),1)+1 as average_duration
from car_rental_company_rental_history
group by car_id
having round(avg(datediff(end_date, start_date)),1)+1 >= 7
order by average_duration desc, car_id desc