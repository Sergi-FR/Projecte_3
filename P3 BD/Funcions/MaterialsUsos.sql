DELIMITER //

CREATE FUNCTION materials_usos() RETURNS VARCHAR(30)
BEGIN
  DECLARE sortida VARCHAR(30) DEFAULT 'Hola mundo';
  SET salida = ‘Hola mundo con variables’;
  RETURN salida;
END
//