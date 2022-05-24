DELIMITER //
CREATE PROCEDURE validacio_colectiu(IN _dni varchar(9), _id_curs int)
BEGIN

    DECLARE _data_curs date;

    SET _data_curs = (SELECT data_final FROM competicio WHERE ID_comp = _id_curs);
    
		IF EXISTS(select * from federat where dni_federat = _dni) THEN
            INSERT INTO competeix VALUES(_dni, _id_curs, _data_curs);
		ELSE
			select "El client no es federat";
		END IF;
END
//

call validacio_colectiu('88606896V', 1);
select * from competeix;