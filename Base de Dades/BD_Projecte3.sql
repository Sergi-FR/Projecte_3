################################
## CREACIÓ DE LA BASE DE DADES##
################################


drop database esqui;
create database esqui;
use esqui;

drop table if exists clients;
create table clients(
	DNI varchar(9),
    primary key (DNI),
    nom varchar(15),
    cognom varchar(35),
    sexe varchar(10),
    data_naix date,
    mobil int(9),
    email varchar(50),
    usuari varchar(20),
    contrasenya varchar(32),
    compte_bancari varchar(50)
);

drop table if exists federat;
create table federat(
	dni_federat varchar(9) not null,
    foreign key (dni_federat) references clients (DNI),
    nivell varchar(5),
    data_caducitat date
);

drop table if exists familia_nombrosa;
create table familia_nombrosa(
	dni_familia varchar(9) not null,
    foreign key (dni_familia) references clients (DNI),
    num_familia varchar(15),
    data_caducitat date
);

drop table if exists monitors;
create table monitors(
	DNI varchar(9),
    primary key (DNI),
    nom varchar(20),
    cognom varchar(35),
    mobil int(9),
    email varchar(50)    
);

drop table if exists cursos;
create table cursos(
	ID int (9) auto_increment,
    primary key (ID),
    nomMonitor varchar(9),
    foreign key (nomMonitor) references monitors(DNI),
    data_curs date,
    preu int(9) 
);

drop table if exists individuals;
create table individuals(
	IDI int(9) not null,
    foreign key (IDI) references cursos (ID)
);

drop table if exists colectius;
create table colectius(
	IDC int(9) not null,
    foreign key (IDC) references cursos (ID),
    data_final date,
    aforament int(5),
    hora_inici time,
    hora_final time
);

drop table if exists competicio;
create table competicio(
	ID_comp int(9) not null,
    foreign key (ID_comp) references cursos (ID),
    nivell_curs varchar(5),
    hora_inici time,
    hora_final time
);

drop table if exists cursar;
create table cursar(
	DNI_client varchar(9) not null,
    foreign key (DNI_client) references clients(DNI),
	ID_curs int(9) not null,
    foreign key (ID_curs) references cursos (ID),
    hora_inici time,
    duracio int(3),
    preu_client int(5)
);

drop table if exists competeix;
create table competeix(
	DNI_federat varchar(9) not null,
    foreign key (DNI_federat) references federat(dni_federat),
	ID_curs int(9) not null,
    foreign key (ID_curs) references competicio(ID_comp),
    data date
);

drop table if exists materials;
create table materials(
	ID int (9) auto_increment,
    primary key (ID),
	marca varchar(15),
    model varchar(15),
    preu double,
    usos int(2),
    estat boolean
);

drop table if exists esquis;
create table esquis(
	ID_esqui int(9) not null,
    foreign key (ID_esqui) references materials(ID),
	llargada double
);

drop table if exists botes;
create table botes(
	ID_botes int(9) not null,
    foreign key (ID_botes) references materials(ID),
	talla int(5)
);

drop table if exists pals;
create table pals(
	ID_pals int(9) not null,
    foreign key (ID_pals) references materials(ID),
	alçada int(3)
);

drop table if exists kit;
create table kit(
	ID int (9) auto_increment,
    primary key (ID),
	preu double,
    usos int(2)
);

drop table if exists llogar;
create table llogar(
	dni_client varchar(9) not null,
    foreign key (dni_client) references clients(DNI),
    id_material int(9) not null,
    foreign key (id_material) references materials(ID),
	data date
);

drop table if exists constar;
create table constar(
	id_kit int(9) not null,
    foreign key (id_kit) references kit(ID),
    id_material int(9) not null,
    foreign key (id_material) references materials(ID)
);



##############################
## INSERCIÓ DE DADES A LA BD##
##############################



