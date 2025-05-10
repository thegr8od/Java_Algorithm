-- 코드를 입력하세요
SELECT o.animal_id, o.name
FROM animal_outs o
JOIN animal_ins i
ON o.animal_id = i.animal_id
order by datediff(o.datetime, i.datetime) desc
limit 2