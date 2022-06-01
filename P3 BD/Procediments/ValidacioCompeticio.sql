DELIMITER //
CREATE PROCEDURE validacio_competicio(IN _dni varchar(9), _id_curs int)
BEGIN

    DECLARE _data_curs date;

    SET _data_curs = (SELECT data_final FROM competicio WHERE ID_comp = _id_curs);
    
		IF EXISTS(select * from federat where dni_federat = _dni) THEN
            INSERT INTO competeix VALUES(_dni, _id_curs, _data_curs);
            #desde java per a saber que ha funcionat el procediment fiquem un select
            select "";
		END IF;
END
//

call validacio_competicio('88606896V', 1);
select * from competeix;
delete from competeix where DNI_federat = "16200526Q";