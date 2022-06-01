DELIMITER //
CREATE PROCEDURE preu_colectiu(IN _dni varchar(9), _id_curs int)
BEGIN
	DECLARE _descompte float;
	DECLARE _preu  float;
    DECLARE _data_curs date;
    DECLARE _preuFinal float;

	SET _preu = (SELECT preu FROM colectius WHERE IDC = _id_curs);
    SET _data_curs = (SELECT data_curs FROM cursos WHERE ID = _id_curs);
    
		IF EXISTS(select * from familia_nombrosa where dni_client = _dni) THEN
			SET _descompte = 0.6;
            SET _preuFinal = _preu * _descompte;
            INSERT INTO llogar_colectiu VALUES(_dni, _id_curs, _data_curs, _preuFinal);
            select '';
		ELSE
			INSERT INTO llogar_colectiu VALUES(_dni, _id_curs, _data_curs, _preu);
            select '';
		END IF;
END
//

call preu_colectiu('07846481P', 2);
SELECT * from llogar_colectiu;
delete from llogar_colectiu;