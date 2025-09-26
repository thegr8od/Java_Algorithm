select a.apnt_no, c.pt_name, a.pt_no, a.mcdp_cd, b.dr_name, a.apnt_ymd
from appointment a
join doctor b
on a.mddr_id = b.dr_id
join patient c
on a.pt_no = c.pt_no
where a.apnt_ymd like '2022-04-13%' and a.apnt_cncl_yn like 'N'
and a.mcdp_cd like 'CS'
order by a.apnt_ymd