CREATE VIEW `Lista de Usuarios y sus Roles` AS
SELECT
    u.usuario_id AS "ID",
	r.rol_nombre AS "Rol",
    u.usuario_nombre AS "Nombre",
    u.email AS "Correo Electrónico",
    u.telefono AS "Teléfono",
    u.contrasena AS "Contraseña",
    u.direccion AS "Dirección"
FROM roles r
NATURAL JOIN usuarios u;