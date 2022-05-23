DROP TRIGGER IF EXISTS kits_guardats;
DELIMITER //
CREATE TRIGGER kits_guardats AFTER INSERT ON kit FOR EACH ROW
BEGIN
	DECLARE totalkits int;
    
    SET totalkits = (SELECT SUM(usos) from kit);
    
END
//

