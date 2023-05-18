Create database cgbjemct;

use cgbjemct;

CREATE TABLE componentes (
    ID_COMP INT NOT NULL AUTO_INCREMENT,
    NOMBRE_COMP VARCHAR(50),
    DESCRIPCION_COMP VARCHAR(100),
    PRECIO_COMP DECIMAL(8,2),
    STOCK_COMP INT,
    PRIMARY KEY (ID_COMP)
);

INSERT INTO componentes (NOMBRE_COMP, DESCRIPCION_COMP, PRECIO_COMP, STOCK_COMP) 
VALUES 
('Procesador Intel Core i7', 'Procesador de 8 núcleos para computadoras de escritorio', 350.00, 50),
('Memoria RAM DDR4 16GB', 'Memoria RAM de alta velocidad para computadoras de escritorio', 120.00, 100),
('Disco duro SSD 500GB', 'Disco duro de estado sólido de alta velocidad para almacenamiento de datos', 90.00, 75),
('Tarjeta gráfica NVIDIA GeForce RTX 3080', 'Tarjeta gráfica de alta gama para juegos y renderización de video', 1200.00, 25);
