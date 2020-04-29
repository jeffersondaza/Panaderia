create database panaderia;

CREATE USER 'persona_app'@'%' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON *.* TO 'persona_app'@'%';
    
use panaderia;

create table  productos(
	nombre varchar(45) not null,
	marca varchar(45) not null,
    fecha_vencimiento varchar(45) not null,
    costo int not null,
    cantidad int not null,
	primary key (nombre)
	);    

insert into productos values("Huevos","Kikes","4/28/2020",3000,10);
select * from productos;

select sum(costo) from productos ;
select nombre, cantidad from productos;

create view new_view as 
select
nombre as nombres,
cantidad as cantidades
from
productos;

drop view new_view;

s
select  from new_view;

