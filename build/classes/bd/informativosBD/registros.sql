/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  YOBANY
 * Created: 12/11/2022
 */

USE mydb;

INSERT INTO estados_civiles (nombre, descripcion)
VALUES 
('sol', 'soltero'),  
('Div', 'divorsiado'),
('Viu', 'viudo'), 
('UL', 'union_libre'),
('Cas', 'casado');


INSERT INTO tipos_documentos (nombre, descripcion)
VALUES 
('CC', 'cédula de ciudadanía'),  
('TI', 'Tarjeta de Identidad'),
('CE', 'Cédula de Extranjería'), 
('PS', 'Pasaporte'),
('PEP', 'Permiso Especial de Protección');

INSERT INTO funcionarios (num_id, nombres, apellidos, sexo, direccion, 
telefono,fecha_nacimiento,tipos_documentos_id,estados_civiles_id)
VALUES('123456','yobany', 'vicentes', 'M', 'cra. 22 # 10-29 funza', '3244561055', '1998-06-09', 1, 1);

INSERT INTO funcionarios (num_id, nombres, apellidos, sexo, direccion, 
telefono,fecha_nacimiento,tipos_documentos_id,estados_civiles_id)
VALUES('123457','alberto', 'jimenez', 'M', 'cra. 22 # 10-50 medellín', '3244561055', '1998-06-09', 1, 1),
      ('109884','sandra', 'lopez', 'F', 'calle 20 # 15-40 armero', '31353564634', '1976-01-17', 1, 2);