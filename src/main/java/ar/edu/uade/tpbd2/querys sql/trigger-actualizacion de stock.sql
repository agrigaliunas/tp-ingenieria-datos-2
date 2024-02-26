--trigger para actualizar el stock de los productos
CREATE TRIGGER ActualizarStockDespuesDeCompra
ON Det_compras
AFTER INSERT
AS
BEGIN
    UPDATE Catalogo_productos
    SET stockActual = stockActual + i.Cantidad
    FROM Catalogo_productos AS cp
    INNER JOIN inserted AS i ON cp.productoID = i.productoID;
END;

CREATE TRIGGER ActualizarStockDespuesDeFacturacion
ON Det_facturacion
AFTER INSERT
AS
BEGIN
    UPDATE Catalogo_productos
    SET stockActual = stockActual - i.Cantidad
    FROM Catalogo_productos AS cp
    INNER JOIN inserted AS i ON cp.productoID = i.productoID;
END;
