use tacourse;

insert into Vehicles (license_plate, maxspeed, kilometers)
values ('AA321BB', 210, 59340);

insert into Cars(engine, model, id_vehicle)
values ('ELECTRIC', 'FORD', 1);

select * from Cars c
inner join Vehicles v
where v.id = c.id_vehicle and c.id = 1;

