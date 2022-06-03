SELECT IDC,data_curs, aforament,nom,hora_inici, hora_final,preu
FROM cursos c, colectius cc, monitors m
where m.DNI = c.nomMonitor and
cc.IDC= c.ID;

SELECT ID_comp, nivell_curs, nom, data_curs, data_final, hora_inici, hora_final,preu
FROM cursos c, competicio cc, monitors m
where m.DNI = c.nomMonitor and
cc.ID_comp= c.ID;

SELECT IDI, nom, data_curs, preu
FROM cursos c, individuals ci, monitors m
where m.DNI = c.nomMonitor and
ci.IDI= c.ID;

