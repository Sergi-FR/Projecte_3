DELIMITER //
CREATE PROCEDURE comprovarCurs_Individual(IN _dni varchar(9), IN _id_curs int, IN hora_inici time, IN duracio int)
BEGIN
    
		IF EXISTS(select * from individuals where IDI = _id_curs) THEN
			#cridem el procediment on llogarem el curs
			call preu_individual(_dni, _id_curs);
		END IF;
END
//

call comprovarCurs_Individual('16200526Q', 2,'15:00:00',4);