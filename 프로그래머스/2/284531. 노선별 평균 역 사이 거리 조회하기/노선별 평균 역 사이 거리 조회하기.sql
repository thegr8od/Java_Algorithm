-- 코드를 작성해주세요
SELECT ROUTE, concat(round(sum(d_between_dist), 1), "km") as TOTAL_DISTANCE, concat(round(avg(d_between_dist), 2), "km") as AVERAGE_DISTANCE
FROM subway_distance
GROUP BY route
order by round(sum(d_between_dist), 1) desc