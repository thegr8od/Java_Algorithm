set @hour = -1;
select (@hour := @hour+1) as hour,
    (select count(hour(datetime))
    from animal_outs
    where hour(datetime)=@hour
    ) as count
from animal_outs
where @HOUR < 23;
