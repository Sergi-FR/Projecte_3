DELIMITER //
CREATE PROCEDURE preu_colectiu(IN _dni varchar(9), _id_curs int)
BEGIN
	DECLARE _descompte float;
	DECLARE _preu  float;
    DECLARE _data_curs date;
    DECLARE _preuFinal float;

	SET _preu = (SELECT preu FROM colectius WHERE IDC = _id_curs);
    SET _data_curs = (SELECT data_curs FROM colectius WHERE IDC = _id_curs);
    
		IF EXISTS(select * from federat where dni_federat = _dni) THEN
            INSERT INTO competeix VALUES(_dni, _id_curs, _data_curs);
		ELSE
			select "El client no es federat";
		END IF;
END
//

call preu_colectiu('16200526Q', 2);
SELECT * from llogar_colectiu;