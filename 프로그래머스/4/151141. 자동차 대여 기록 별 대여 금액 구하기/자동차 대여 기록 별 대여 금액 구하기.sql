SELECT a.history_id, 
       TRUNCATE(b.daily_fee * a.day * (1 - IFNULL(c.discount_rate, 0) * 0.01), 0) AS fee
FROM (
    SELECT history_id, car_id, DATEDIFF(end_date, start_date)+1 AS day,
           CASE
               WHEN DATEDIFF(end_date, start_date)+1 >= 90 THEN '90일 이상'
               WHEN DATEDIFF(end_date, start_date)+1 >= 30 THEN '30일 이상'
               WHEN DATEDIFF(end_date, start_date)+1 >= 7 THEN '7일 이상'
               ELSE NULL
           END AS duration_type
    FROM car_rental_company_rental_history
) a
JOIN car_rental_company_car b
    ON a.car_id = b.car_id
LEFT JOIN car_rental_company_discount_plan c
    ON b.car_type = c.car_type AND a.duration_type = c.duration_type
WHERE b.car_type = '트럭'
ORDER BY fee DESC, a.history_id DESC;