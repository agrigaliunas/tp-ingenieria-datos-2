--trigger para actualizar la categorizacion y los pedidos_realizados

CREATE TRIGGER actCategorizacionYPedidos
ON Facturacion
AFTER INSERT
AS
BEGIN
    UPDATE Usuarios
    SET 
        categorizacion = CASE
                            WHEN (SELECT COUNT(*) FROM Facturacion WHERE Facturacion.nickname = Usuarios.nickname) <10 or pedidos_realizados <10 THEN 'bajo'
                            WHEN (SELECT COUNT(*) FROM Facturacion WHERE Facturacion.nickname = Usuarios.nickname) < 20 or pedidos_realizados <20 THEN 'medio'
                            ELSE 'alto'
                        END,
        pedidos_realizados = (SELECT COUNT(*) FROM Facturacion WHERE Facturacion.nickname = Usuarios.nickname)
    FROM
        Usuarios
    INNER JOIN
        inserted ON Usuarios.nickname = inserted.nickname;
END;
