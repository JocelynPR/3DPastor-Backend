-- CREATE VIEW `Lista de Usuarios y sus Compras` AS
SELECT
    u.usuario_id AS "ID",
    u.usuario_nombre AS "Nombre",
    c.compras_id AS "Id de Compra",
    c.fecha_compra AS "Fecha de Compra",
    ec.estado_compra AS "Estado",
    
    chp.cantidad_compra AS "Cantidad Comprada",
    p.nombre_producto AS "Producto Comprado",
    (chp.cantidad_compra * p.precio) AS "Subtotal"
FROM usuarios u
NATURAL JOIN compras c
NATURAL JOIN estado_compra ec
NATURAL JOIN compras_has_productos chp
INNER JOIN productos p
ON chp.productos_id = p.producto_id;