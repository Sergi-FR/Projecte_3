DELIMITER //
CREATE PROCEDURE preu_individual(IN _dni varchar(9), IN _id_curs int, IN _hora_inici time, IN _duracio int)
BEGIN
	DECLARE _descompte float;
	DECLARE _preu  float;
    DECLARE _preuFinal float;

	SET _preu = (SELECT preu FROM individuals WHERE IDI = _id_curs);
    
		IF (_duracio in (1,2)) THEN
			SET _descompte = 0.8;
            SET _preuFinal = _preu * _descompte;
            INSERT INTO llogar_individual VALUES(_dni, _id_curs, _hora_inici, _duracio, _preuFinal);
		ELSEIF (_duracio in (3,4,5)) THEN
			SET _descompte = 0.7;
            SET _preuFinal = _preu * _descompte;
			INSERT INTO llogar_individual VALUES(_dni, _id_curs, _hora_inici, _duracio, _preuFinal);
		elseif (_duracio >= 6) THEN
			SET _descompte = 0.5;
            SET _preuFinal = _preu * _descompte;
			INSERT INTO llogar_individual VALUES(_dni, _id_curs, _hora_inici, _duracio, _preuFinal);
        ELSE
			INSERT INTO llogar_individual VALUES(_dni, _id_curs, _hora_inici, _duracio, _preu);
		END IF;
END
//

call preu_individual('16200526Q', 2,'09:00:00',3);
SELECT * from llogar_individual;
delete from llogar_individual where DNI_client like '07846481P';