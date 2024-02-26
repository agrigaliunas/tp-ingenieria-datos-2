
drop table Det_compras;
drop table Det_facturacion;
drop table Catalogo_productos;
drop table Facturacion;
drop table Usuarios;
drop table Compras;

create table Usuarios (
	nickname varchar(100) PRIMARY KEY not null,
	nombre varchar(50) not null,
	apellido varchar(50) not null,
	domicilio varchar(100) not null,
	categorizacion varchar(20) not null,
	pedidos_realizados int,
	contrasena varchar(100) not null
	)

create table Catalogo_productos (
	productoID varchar(100) UNIQUE not null,
	nombre varchar(100) not null,
	marca varchar(100) not null,
	descripcion varchar(500) not null,
	precio float not null,
	stock_actual int,
	categoria varchar(100),
	)

create table Compras (
	ID_compra int PRIMARY KEY IDENTITY (1,1),
	Fecha_fact DATETIME not null
	)

create table Det_compras (
	ID_det_compra int PRIMARY KEY IDENTITY (1,1),
	ID_compra int not null,
	productoID varchar(100) not null,
	Cantidad int not null,
	Precio_unit float not null,
	FOREIGN KEY (ID_compra) REFERENCES Compras(ID_compra),
	FOREIGN KEY (productoID) REFERENCES Catalogo_productos(productoID)
	)

create table Facturacion (
	ID_facturacion int PRIMARY KEY IDENTITY (1,1),
	Fecha_fact DATETIME not null,
	nickname varchar(100) not null,
	FOREIGN KEY (nickname) REFERENCES Usuarios(nickname)
	)

create table Det_facturacion (
	ID_det_facturacion int PRIMARY KEY IDENTITY (1,1),
	ID_facturacion int not null,
	productoID varchar(100) not null,
	Cantidad int not null,
	Precio_unit float not null,
	forma_pago varchar(100) not null,
	FOREIGN KEY (ID_facturacion) REFERENCES Facturacion(ID_facturacion),
	FOREIGN KEY (productoID) REFERENCES Catalogo_productos(productoID)
	)
