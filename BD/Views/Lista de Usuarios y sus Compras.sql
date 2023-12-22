CREATE VIEW `Lista de Usuarios y sus Compras` AS
SELECT
    u.usuario_id AS "ID",
    u.usuario_nombre AS "Nombre",
    c.compras_id AS "Id de Compra",
    c.fecha_compra AS "Fecha de Compra",
    ec.estado_compra AS "Estado",
    SUM( (chp.cantidad_compra * p.precio) ) AS "Total"
FROM usuarios u
NATURAL JOIN compras c
NATURAL JOIN estado_compra ec
NATURAL JOIN compras_has_productos chp
INNER JOIN productos p
ON chp.productos_id = p.producto_id
GROUP BY `Id de Compra`;