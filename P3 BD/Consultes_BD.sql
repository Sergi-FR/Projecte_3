#Select taula botes
SELECT *
		from materials M
		where M.ID = (select ID_botes
							from botes B
                            where M.ID = B.ID_botes);

#Select taula pals
SELECT *
		from materials M
		where M.ID = (select ID_pals
							from pals P
                            where M.ID = P.ID_pals);

# Select taula esquis                            
SELECT *
		from materials M
		where M.ID = (select ID_esqui
							from esquis E
                            where M.ID = E.ID_esqui);

#Select dades del curs individual
select C.ID, C.nomMonitor, C.data_curs, I.preu
from cursos C, individuals I
where C.ID= I.IDI;


#Select dades del curs col·lectiu
select C.ID, C.nomMonitor, C.data_curs, CO.aforament, CO.hora_inici, CO.hora_final, CO.preu
from cursos C, colectius CO
where C.ID= CO.IDC;


# Select dades del curs competitiu
select distinct C.ID, C.nomMonitor, C.data_curs, CX.data_curs ,COM.nivell_curs, COM.hora_inici, COM.hora_final, COM.preu
from cursos C, competicio COM, competeix CX
where C.ID = COM.ID_comp and CX.ID_curs =  COM.ID_comp;

select C.ID, C.nomMonitor, C.data_curs AS data_inici, CO.data_final, CO.nivell_curs ,CO.hora_inici, CO.hora_final, CO.preu
from competicio CO, cursos C
where C.ID = CO.ID_comp;

#Select utilitzat per java per tenir les dades dels clients que necessitem
SELECT C.DNI, C.nom, C.cognom, C.sexe, B.num_familia, B.dataFa_caducitat , F.dataFe_caducitat, F.nivell 
FROM clients C LEFT JOIN familia_nombrosa B ON C.DNI = B.dni_client LEFT JOIN federat F ON C.DNI = F.dni_federat;

select * from competicio;

#Client llogar curs Individual
select C.DNI, C.nom, I.ID_curs, I.preu_client
from clients C, llogar_individual I
where C.DNI like '07846481P' and
C.DNI = I.DNI_client;

#Client llogar curs Col·lectiu
select C.DNI, C.nom, CO.ID_curs, CO.preu_final, CO.data_curs
from clients C, llogar_colectiu CO
where C.DNI like '16200526Q' and
C.DNI = CO.DNI_client;

#Client llogar curs Competicio
select C.DNI, C.nom, COM.ID_curs,  COMP.nivell_curs,COM.data_curs
from clients C, federat F, competeix COM, competicio COMP
where F.dni_federat like '16200526Q' and
C.DNI = F.dni_federat and
F.dni_federat = COM.DNI_federat and
COM.ID_curs = COMP.ID_comp;