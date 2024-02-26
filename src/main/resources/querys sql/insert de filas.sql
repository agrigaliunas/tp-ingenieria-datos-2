insert into usuarios (nickname, nombre,apellido, domicilio, categorizacion, contrasena, pedidos_realizados) 
values	('franlee99', 'francisco', 'lee','calle 123','low' , '1234', 1),
		('gabo', 'gabriel', 'rios','calle 456','medium' , '5678', 1),
		('agus', 'agustin', 'grigaliunas','calle 789','high' , '9012', 1);
			

insert into catalogo_productos (productoID,nombre, marca, descripcion, precio, stock_actual, categoria)
values	('1','producto','marca','descripcion',250000,500,'categoria'),
		('3','producto1','marca1','descripcion1',100000,500,'categoria1'),
		('1000','producto2','marca2','descripcion2',80000,500,'categoria2');

insert into Compras (Fecha_fact) 
values	(GETDATE()),
		(GETDATE()-1),
		(GETDATE()-2);

insert into Det_compras (ID_compra, productoID, Cantidad, Precio_unit) 
values	(1,'1',5,250000),
		(1,'3',2,100000),
		(2,'1000',12,80000);

insert into facturacion (fecha_fact, nickname) 
values	(getdate(), 'franlee99'),
		(getdate()-1,'gabo'),
		(getdate()-4,'agus');

insert into det_facturacion (ID_facturacion,productoID, cantidad, precio_unit, forma_pago) 
values	(1,'1',12, 250000, 'efectivo'),
		(2,'3',10,100000, 'debito'),
		(3,'1000',15,80000, 'debito');

select * from usuarios;
select * from catalogo_productos;
select * from compras;
select * from det_compras;
select * from facturacion;
select * from det_facturacion;

