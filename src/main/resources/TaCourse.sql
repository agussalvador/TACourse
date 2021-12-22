drop database tacourse;
create database tacourse;
use tacourse;

create table Vehicles(	
	id INT AUTO_INCREMENT PRIMARY KEY,
	license_plate VARCHAR(30) NOT NULL,
    maxspeed float(4) NOT NULL,
    kilometers float(4) NOT NULL
);

create table Cars(
	id INT AUTO_INCREMENT PRIMARY KEY,
    engine ENUM('ELECTRIC','HYBRID','COMBUSTION'),
    model ENUM('FIAT','FORD','RENAULT','FERRARI'),
    id_vehicle INT not null,
    foreign key (id_vehicle) references Vehicles(id)
);

create table Motorbikes(
	id INT AUTO_INCREMENT PRIMARY KEY,
    type ENUM('CROSS','RALLY','CHOPPER','SPORT','TOURING','SCOOTER'),
    id_vehicle INT not null,
    foreign key (id_vehicle) references Vehicles(id)
);

create table CarWash(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    address VARCHAR(30) NOT NULL,
    type ENUM ('AUTOMATIC','FULL-SERVICE','SELF-SERVICE'),
    id_car INT not null,
    foreign key (id_car) references Cars(id)
);

create table CarDealership(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    address VARCHAR(30) NOT NULL,
    earnings float(4),
    id_car INT not null,
    foreign key (id_car) references Cars(id)
);

create table Garage(
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    address VARCHAR(30) NOT NULL,
    max_places INT NOT NULL,
    id_car INT not null,
    foreign key (id_car) references Cars(id)
);