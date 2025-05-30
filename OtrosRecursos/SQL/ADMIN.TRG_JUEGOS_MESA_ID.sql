CREATE OR REPLACE EDITIONABLE TRIGGER "ADMIN"."TRG_JUEGOS_MESA_ID" 
BEFORE INSERT ON Juegos_mesa
FOR EACH ROW
BEGIN
  IF :NEW.id IS NULL THEN
    :NEW.id := seq_juegos_mesa_id.NEXTVAL;
  END IF;
END;

/
ALTER TRIGGER "ADMIN"."TRG_JUEGOS_MESA_ID" ENABLE;

