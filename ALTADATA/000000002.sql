CREATE TABLE cliente (
  RUT_CLIENTE char(10)  NOT NULL,
  APELLIDOS_NOMBRES varchar(100) ,
  RAZON_SOCIAL varchar(100),
  DIRECCION varchar(100),
  TELEFONO varchar(10) ,
  CORREO_ELECTRONICO varchar(50),
  NOMBRE_CONTACTO varchar(100),
  TELEFONO_CONTACTO varchar(10),
  PRIMARY KEY (RUT_CLIENTE)
);



insert  into cliente(RUT_CLIENTE,APELLIDOS_NOMBRES,RAZON_SOCIAL,DIRECCION,TELEFONO,CORREO_ELECTRONICO,NOMBRE_CONTACTO,TELEFONO_CONTACTO) values ('0265178523','PALACIOS ATARAMA SANDRA DEL ROSARIO','SRL S','LOS SAUCES 12312','3498590328','3945890@GMAIL.COM','SARA PALACIOS','43957345');
insert  into cliente(RUT_CLIENTE,APELLIDOS_NOMBRES,RAZON_SOCIAL,DIRECCION,TELEFONO,CORREO_ELECTRONICO,NOMBRE_CONTACTO,TELEFONO_CONTACTO) values ('21412344-8','ABC JUAN','ABC SAC','LOS MEDANOS SDS','6890883748','ABC@GMAIL.COM','ABC','2387430948');
insert  into cliente(RUT_CLIENTE,APELLIDOS_NOMBRES,RAZON_SOCIAL,DIRECCION,TELEFONO,CORREO_ELECTRONICO,NOMBRE_CONTACTO,TELEFONO_CONTACTO) values ('37467634-4','ADANAQUE MARQEZ LUIS','LMR SAC','LOS ROSALES 324324','24581275','ADANAQUE28378@GMAIL.COM','ANDREA MARQUEZ','23325');
insert  into cliente(RUT_CLIENTE,APELLIDOS_NOMBRES,RAZON_SOCIAL,DIRECCION,TELEFONO,CORREO_ELECTRONICO,NOMBRE_CONTACTO,TELEFONO_CONTACTO) values ('4445815519','SALDARRIAGA LOPEZ JULIO CESAR','SALDARRIAGA Y ASOCIADOS SA.','CALLE LOS GENANIO 3658','5387629048','LOZADA23523@GMAIL.COM','LOZADA LOPEZ MARLON','346892688');

CREATE TABLE usuario (
  RUT_USUARIO char(10),
  APELLIDOS_NOMBRES varchar(100),
  TELEFONO varchar(10) ,
  DIRECCION varchar(100) ,
  PRIMARY KEY (RUT_USUARIO)
) ;

insert  into usuario(RUT_USUARIO,APELLIDOS_NOMBRES,TELEFONO,DIRECCION) values ('21412344-9','JUAREZ JUAREZ JUAN','234627483','AV GRAU 123');
insert  into usuario(RUT_USUARIO,APELLIDOS_NOMBRES,TELEFONO,DIRECCION) values ('44458120-1','VASQUEZ MARQUEZ MIGUEL ANGEL','3274623','LOS HERALDOS 237 COQUIMBOO');
insert  into usuario(RUT_USUARIO,APELLIDOS_NOMBRES,TELEFONO,DIRECCION) values ('45872309-2','PALACIOS PERICHE MEDARDO','982491823','LOS GERANIOS 123|1');
insert  into usuario(RUT_USUARIO,APELLIDOS_NOMBRES,TELEFONO,DIRECCION) values ('45872319-2','SDGGSDG','353426','DGDSFGSDFG');
insert  into usuario(RUT_USUARIO,APELLIDOS_NOMBRES,TELEFONO,DIRECCION) values ('7678776-2','SALAZAR JUAREZ JUAN EDUARDO','458723840','SANTIAGO DE CHILE CALLE LOS LORES 37518');


CREATE TABLE registro_llamada (
  COD_REGISTRO int(11) NOT NULL AUTO_INCREMENT,
  RUT_CLIENTE char(10) ,
  RUT_USUARIO char(10), 
  FECHA_HORA_LLAMADA varchar(100),
  INCIDENTE_CLIENTE varchar(500) ,
  INDICACION_ENTREGADA varchar(500),
  PRIMARY KEY (COD_REGISTRO),
  KEY FK_RUT_CLIENTE (RUT_CLIENTE),
  KEY FK_RUT_USUARIO (RUT_USUARIO),
  CONSTRAINT FK_RUT_CLIENTE FOREIGN KEY (RUT_CLIENTE) REFERENCES cliente (RUT_CLIENTE),
  CONSTRAINT FK_RUT_USUARIO FOREIGN KEY (RUT_USUARIO) REFERENCES usuario (RUT_USUARIO)
) ;
insert  into registro_llamada(COD_REGISTRO,RUT_CLIENTE,RUT_USUARIO,FECHA_HORA_LLAMADA,INCIDENTE_CLIENTE,INDICACION_ENTREGADA) values (1,'0265178523','45872309-2','18-08-2020 16:57','SIN INTERNET','REINICIO DEL EQUIPO');
insert  into registro_llamada(COD_REGISTRO,RUT_CLIENTE,RUT_USUARIO,FECHA_HORA_LLAMADA,INCIDENTE_CLIENTE,INDICACION_ENTREGADA) values (2,'4445815519','7678776-2','18-08-2020 16:57','SIN INTERNET Y FALLAS EN EL EQUIPO','RESETEO EN EL SISTEMA DE LA LINEA');
insert  into registro_llamada(COD_REGISTRO,RUT_CLIENTE,RUT_USUARIO,FECHA_HORA_LLAMADA,INCIDENTE_CLIENTE,INDICACION_ENTREGADA) values (3,'21412344-8','44458120-1','10-12-2018 14:30','COBERTURA CON FALLAS','CAMBIO DE CHIP');
insert  into registro_llamada(COD_REGISTRO,RUT_CLIENTE,RUT_USUARIO,FECHA_HORA_LLAMADA,INCIDENTE_CLIENTE,INDICACION_ENTREGADA) values (4,'4445815519','7678776-2','01-08-2019 16:57','FALLAS DE NAVEGACIÓN','ACTUALIZACIÓN DEL VPN');


 