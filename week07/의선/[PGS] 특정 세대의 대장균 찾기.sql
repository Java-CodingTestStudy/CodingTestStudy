select id
from ecoli_data as b
where b.parent_id in(select a.id
from ecoli_data as a
where a.parent_id in (select id
from ecoli_data
where parent_id is null)  )