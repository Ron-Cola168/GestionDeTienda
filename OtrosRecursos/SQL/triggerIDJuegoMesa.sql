CREATE OR REPLACE TRIGGER trg_juegos_mesa_id
BEFORE INSERT ON Juegos_mesa
FOR EACH ROW
BEGIN
  IF :NEW.id IS NULL THEN
    :NEW.id := seq_juegos_mesa_id.NEXTVAL;
  END IF;
END;
/