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
select C.ID, C.nomMonitor, C.data_curs, CX.data_fi ,COM.nivell_curs, COM.hora_inici, COM.hora_final, COM.preu
from cursos C, competicio COM, competeix CX
where C.ID = COM.ID_comp and CX.ID_curs =  COM.ID_comp;

#Select utilitzat per java per tenir les dades dels clients que necessitem
SELECT C.DNI, C.nom, C.cognom, C.sexe, C.email, B.num_familia, B.data_caducitat AS dataFa_caducitat , F.data_caducitat AS dataFe_caducitat, F.nivell 
FROM clients C LEFT JOIN familia_nombrosa B ON C.DNI = B.dni_client LEFT JOIN federat F ON C.DNI = F.dni_federat;
