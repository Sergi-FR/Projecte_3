DELIMITER //
CREATE PROCEDURE comprovar_curs(IN _dni varchar(9), _id_curs int)
BEGIN
    
		IF EXISTS(select * from colectius where IDC = _id_curs) THEN
			#cridem el procediment on llogarem el curs
			call preu_colectiu(_dni, _id_curs);
		ELSE
			call validacio_colectiu(_dni, _id_curs);
		END IF;
END
//

call comprovar_curs('16200526Q', 2);