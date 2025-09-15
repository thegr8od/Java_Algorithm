select c.member_name, b.review_text, date_format(b.review_date, '%Y-%m-%d') as review_date
from (select member_id
     from rest_review
     group by member_id
     order by count(*) desc
     limit 1) a
join rest_review b
on a.member_id = b.member_id
join member_profile c
on a.member_id = c.member_id
order by review_date, b.review_text