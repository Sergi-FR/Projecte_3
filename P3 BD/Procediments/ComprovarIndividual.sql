DELIMITER //
CREATE PROCEDURE comprovarCurs_Individual(IN _dni varchar(9), IN _id_curs int, IN _hora_inici time, IN _duracio int)
BEGIN
		DECLARE _error varchar(30);
        SET _error = "El curs no es individual";
    
		IF EXISTS(select * from individuals where IDI = _id_curs) THEN
			#cridem el procediment on llogarem el curs
			call preu_individual(_dni, _id_curs, _hora_inici, _duracio);
		ELSE
			select _error; 
		END IF;
END
//

call comprovarCurs_Individual('16200526Q', 3,'15:00:00',1);