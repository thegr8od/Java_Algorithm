select c.member_name, a.review_text, date_format(a.review_date, '%Y-%m-%d') as review_date
from rest_review a
join (select member_id, count(*) cnt
     from rest_review
     group by member_id
     order by count(*) desc
     limit 1) b
on a.member_id = b.member_id
join member_profile c
on a.member_id = c.member_id
order by a.review_date, a.review_text
