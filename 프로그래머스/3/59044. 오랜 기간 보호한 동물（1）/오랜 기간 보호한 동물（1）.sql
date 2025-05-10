-- 코드를 입력하세요
SELECT i.name, i.datetime
FROM animal_ins i
LEFT JOIN animal_outs o
ON i.animal_id = o.animal_id
where o.animal_id is null
order by i.datetime
limit 3