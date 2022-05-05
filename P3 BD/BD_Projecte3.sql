################################
## CREACIÓ DE LA BASE DE DADES##
################################


drop database esqui;
create database esqui;
use esqui;

#drop table if exists clients;
create table clients(
	DNI varchar(9),
    primary key (DNI),
    nom varchar(15),
    cognom varchar(35),
    sexe varchar(10),
    data_naix date,
    telefon int(9),
    email varchar(50),
    usuari varchar(20),
    contrasenya varchar(32),
    compte_bancari varchar(50)
);

#drop table if exists federat;
create table federat(
	dni_federat varchar(9) not null,
    foreign key (dni_federat) references clients (DNI),
    nivell varchar(5),
    data_caducitat date
);

#drop table if exists familia_nombrosa;
create table familia_nombrosa(
	dni_client varchar(9) not null,
    foreign key (dni_client) references clients (DNI),
    num_familia varchar(25),
    data_caducitat date
);

#drop table if exists monitors;
create table monitors(
	DNI varchar(9),
    primary key (DNI),
    nom varchar(20),
    cognom varchar(35),
    telefon int(9),
    email varchar(50)    
);

#drop table if exists cursos;
create table cursos(
	ID int (9) auto_increment,
    primary key (ID),
    nomMonitor varchar(9),
    foreign key (nomMonitor) references monitors(DNI),
    data_curs date
);

#drop table if exists individuals;
create table individuals(
	IDI int(9) not null,
    foreign key (IDI) references cursos (ID),
    preu int(9) 
);

#drop table if exists colectius;
create table colectius(
	IDC int(9) not null,
    foreign key (IDC) references cursos (ID),
    data_final date,
    aforament int(5),
    hora_inici time,
    hora_final time,
    preu int(9) 
);

#drop table if exists competicio;
create table competicio(
	ID_comp int(9) not null,
    foreign key (ID_comp) references cursos (ID),
    nivell_curs varchar(5),
    hora_inici time,
    hora_final time,
    preu int(9) 
);

#drop table if exists cursar;
create table cursar(
	DNI_client varchar(9) not null,
    foreign key (DNI_client) references clients(DNI),
	ID_curs int(9) not null,
    foreign key (ID_curs) references cursos (ID),
    hora_inici time,
    duracio int(3),
    preu_client int(5)
);

#drop table if exists competeix;
create table competeix(
	DNI_federat varchar(9) not null,
    foreign key (DNI_federat) references federat(dni_federat),
	ID_curs int(9) not null,
    foreign key (ID_curs) references competicio(ID_comp),
    data date
);

#drop table if exists materials;
create table materials(
	ID int (9) auto_increment,
    primary key (ID),
	marca varchar(20),
    model varchar(35),
    preu double,
    usos int(2),
    estat boolean
);

#drop table if exists esquis;
create table esquis(
	ID_esqui int(9) not null,
    foreign key (ID_esqui) references materials(ID),
	llargada varchar(8)
);

#drop table if exists botes;
create table botes(
	ID_botes int(9) not null,
    foreign key (ID_botes) references materials(ID),
	talla varchar(8)
);

#drop table if exists pals;
create table pals(
	ID_pals int(9) not null,
    foreign key (ID_pals) references materials(ID),
	alçada varchar(8)
);

#drop table if exists kit;
create table kit(
	ID int (9) auto_increment,
    primary key (ID),
	preu double,
    usos int(2)
);

#drop table if exists llogar;
create table llogar(
	dni_client varchar(9) not null,
    foreign key (dni_client) references clients(DNI),
    id_material int(9) not null,
    foreign key (id_material) references materials(ID),
	data date
);

#drop table if exists constar;
create table constar(
	id_kit int(9) not null,
    foreign key (id_kit) references kit(ID),
    id_materialB int(9) not null,
    foreign key (id_materialB) references materials(ID),
    id_materialP int(9) not null,
    foreign key (id_materialP) references materials(ID),
    id_materialE int(9) not null,
    foreign key (id_materialE) references materials(ID)
);



##############################
## INSERCIÓ DE DADES A LA BD##
##############################

#INSERCIÓ DE DADES A LA TAULA CLIENTS
insert into clients values('07846481P','Pablo','Ramirez','Masculi','1998-04-22','644532989','pablor@gmail.com','pablor',MD5('pablo'),'ES4402118934198712574768');
insert into clients values('16200526Q','Saray','Paredes','Femeni','2004-10-11','664787502','sarayp@gmail.com','sarayp',MD5('saray'),'ES5102297903487688506094');
 #select * from clients;


#INSERCIÓ DE DADES A LA TAULA CLIENTS FEDERATS
insert into federat values('16200526Q','mitg','2023-01-17');
#select * from federat;


#INSERCIÓ DE DADES A LA TAULA CLIENTS QUE SON FAMILIA_NOMBROSA
insert into familia_nombrosa values('07846481P','9808799236510749','2028-11-22');
#select * from familia_nombrosa;


#INSERCIÓ DE DADES A LA TAULA MONITORS
insert into monitors values('23464241D','Pau','Moreno','664598221','paumoreno@gmail.com');
insert into monitors values('10510049S','Pep','Pedrosa','644111010','peppedrosa@gmail.com');
insert into monitors values('59288393M','Jaume','Curulles','644203990','jaumecurulles@gmail.com');
#select * from monitors;


#INSERCIÓ DE DADES A LA TAULA CURSOS
insert into cursos values('1','10510049S','2022-12-07');
insert into cursos values(default,'23464241D','2023-01-11');
#select * from cursos;


#INSERCIÓ DE DADES A LA TAULA CURSOS_INDIVIDUALS
#select * from individuals;

#INSERCIÓ DE DADES A LA TAULA CURSOS_COL·LECTIUS
insert into colectius values(2,'2023-01-21','20','08:00:00','20:00:00','30');
#select * from colectius;


#INSERCIÓ DE DADES A LA TAULA CURSOS DE COMPETICIO
insert into competicio values('1','alt','08:00:00','19:00:00','50');
#select * from competicio;


#INSERCIÓ DE DADES A LA TAULA CURSAR
insert into cursar values('07846481P','2','10:00:00','3','14');
#select * from cursar;
#delete from cursar where DNI_client = '16200526Q';


#INSERCIÓ DE DADES A LA TAULA COMPETEIX
insert into competeix values('16200526Q','1','2022-11-28');
#select * from competeix;


#INSERCIÓ DE DADES A LA TAULA MATERIALS
insert into materials values('1','Rossignol','Alltrack 90','134.99','0','1');
insert into materials values(default,'Rossignol','Alltrack Pro 100','180','0','1');
insert into materials values(default,'Hawx','Atomic Magna 80','80','0','1');
insert into materials values(default,'Head','FX GT','115','0','1');
insert into materials values(default,'Head','FX GT W','120','0','1');
insert into materials values(default,'Roces','IDEA FREE','179.99','0','1');
insert into materials values(default,'Salomon','X PRO 100','155','0','1');
insert into materials values(default,'Leki','Worldcup Racing SL','21.43','0','1');
insert into materials values(default,'Altus','Sports','36.38','0','1');
insert into materials values(default,'Rossignol','Sports 2','40.15','0','1');
insert into materials values(default,'Salomon','X 08','17','0','1');
insert into materials values(default,'Atomic','Joy','40','0','1');
insert into materials values(default,'Head','Multi','18','0','1');
insert into materials values(default,'Black','Crevice','26.69','0','1');
insert into materials values(default,'Atomic','VANTAGE 75','175','0','1');
insert into materials values(default,'Rossignol','EXPERIENCE 74','159.99','0','1');
insert into materials values(default,'Head','V-SHAPE V6','128','0','1');
insert into materials values(default,'K2','KONIC 75','160','0','1');
insert into materials values(default,'K2','PRESS SKIS','200','0','1');
insert into materials values(default,'SALOMON','XDR 76 ST','199.99','0','1');
insert into materials values(default,'Rossignol','EXPERIENCE 88','185','0','1');
#select * from materials;


#INSERCIÓ DE DADES A LA TAULA ESQUIS
insert into esquis values(15,'170cm');
insert into esquis values(16,'152cm');
insert into esquis values(17,'177cm');
insert into esquis values(18,'149cm');
insert into esquis values(19,'139cm');
insert into esquis values(20,'160cm');
insert into esquis values(21,'188cm');
#select * from esquis;


#INSERCIÓ DE DADES A LA TAULA BOTES
insert into botes values('1','38');
insert into botes values('2','41');
insert into botes values('3','44');
insert into botes values('4','40');
insert into botes values('5','38');
insert into botes values('6','36');
insert into botes values('7','42');
#select * from botes;


#INSERCIÓ DE DADES A LA TAULA PALS
insert into pals values('8','130cm');
insert into pals values('9','115cm');
insert into pals values('10','120cm');
insert into pals values('11','135cm');
insert into pals values('12','125cm');
insert into pals values('13','110cm');
insert into pals values('14','140cm');
#select * from pals;


#INSERCIÓ DE DADES A LA TAULA KIT
insert into kit values('1','45','0');
insert into kit values(default,'35','0');
insert into kit values(default,'57','0');
select * from kit;
#INSERCIÓ DE DADES A LA TAULA LLOGAR
#INSERCIÓ DE DADES A LA TAULA CONSTAR
insert into constar values('2','2','10','18');
insert into constar values('1','1','9','15');

