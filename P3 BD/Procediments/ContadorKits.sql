DELIMITER //
DROP procedure contador_kits;
CREATE PROCEDURE contador_kits(IN _id_materialB INT(3), IN _id_materialP INT(3), IN _id_materialE INT(3))

BEGIN	
	declare _id_material int;
        SELECT * into _id_material
        from constar
        group by id_kit
        having id_materialB = _id_materialB and id_materialP = _id_materialP and id_materialE = _id_materialE;
        
        IF _id_material != NULL then
        
        insert into kit values(default,'30','0');
        
        ELSE
        
        update kit set usos = 1;
        
        END IF;

END
//

call contador_kits(1,9,15);