SELECT c.id
FROM ecoli_data a   -- root
JOIN ecoli_data b   ON b.parent_id = a.id     -- second_level
JOIN ecoli_data c   ON c.parent_id = b.id     -- third_level
WHERE a.parent_id IS NULL;