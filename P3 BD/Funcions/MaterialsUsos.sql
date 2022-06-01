DELIMITER //

CREATE FUNCTION materials_usos() RETURNS INT(3)
BEGIN
	DECLARE EstatMaterial int;
	DECLARE M_usos int;
    DECLARE Total_Materials int;
    DECLARE contador int;
    SET contador = 1;
    SET Total_Materials = (select count(*) from materials);
    
    
		WHILE ( (contador < Total_Materials) OR (contador = TotalMaterials) ) DO
			SET M_usos = (select usos from materials where ID = contador); 
			IF M_usos > 10 THEN
				UPDATE materials SET estat = 0;
			END IF;
			SET contador = contador + 1;
		END WHILE;
    RETURN null;
END
//


