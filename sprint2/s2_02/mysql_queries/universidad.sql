-- 1. 
SELECT apellido1, apellido2, nombre FROM persona ORDER BY apellido1, apellido2, nombre;
-- 2. 
SELECT nombre, apellido1, apellido2 FROM persona WHERE telefono IS NULL;
-- 3. 
SELECT * FROM persona WHERE YEAR(fecha_nacimiento) = 1999;
-- 4. 
SELECT * FROM profesor WHERE telefono IS NULL AND nif LIKE '%K';
-- 5. 
SELECT nombre FROM asignatura WHERE cuadrimestre = 1 AND curso = 3 AND id_grado = 7;
-- 6. 
SELECT p.apellido1, p.apellido2, p.nombre, d.nombre AS departamento FROM profesor pr JOIN persona p ON pr.id_profesor = p.id JOIN departamento d ON pr.id_departamento = d.id ORDER BY p.apellido1, p.apellido2, p.nombre;
-- 7. 
SELECT a.nombre, ce.anyo_inicio, ce.anyo_fin FROM alumno_se_matricula_asignatura asm JOIN asignatura a ON asm.id_asignatura = a.id JOIN curso_escolar ce ON asm.id_curso_escolar = ce.id JOIN persona p ON asm.id_alumno = p.id WHERE p.nif = '26902806M';
-- 8. 
SELECT DISTINCT d.nombre FROM departamento d JOIN profesor p ON d.id = p.id_departamento JOIN asignatura a ON p.id_profesor = a.id_profesor JOIN grado g ON a.id_grado = g.id WHERE g.nombre = 'Ingeniería Informática' AND g.plan = '2015';
-- 9. 
SELECT DISTINCT p.* FROM persona p JOIN alumno_se_matricula_asignatura asm ON p.id = asm.id_alumno JOIN curso_escolar ce ON asm.id_curso_escolar = ce.id WHERE ce.anyo_inicio = 2018 AND ce.anyo_fin = 2019;

-- Resuelve las 6 siguientes consultas utilizando las cláusulas LEFT JOIN y RIGHT JOIN.
-- 1. 
SELECT d.nombre AS nombre_departamento, p.apellido1, p.apellido2, p.nombre FROM profesor pr LEFT JOIN departamento d ON pr.id_departamento = d.id JOIN persona p ON pr.id_profesor = p.id ORDER BY nombre_departamento, p.apellido1, p.apellido2, p.nombre;
-- 2. 
SELECT p.apellido1, p.apellido2, p.nombre FROM persona p LEFT JOIN profesor pr ON p.id = pr.id_profesor WHERE pr.id_departamento IS NULL;
-- 3. 
SELECT d.nombre FROM departamento d LEFT JOIN profesor pr ON d.id = pr.id_departamento WHERE pr.id_departamento IS NULL;
-- 4. 
SELECT p.apellido1, p.apellido2, p.nombre FROM persona p LEFT JOIN profesor pr ON p.id = pr.id_profesor LEFT JOIN asignatura a ON pr.id_profesor = a.id_profesor
WHERE a.id_profesor IS NULL;
-- 5. 
SELECT a.nombre FROM asignatura a LEFT JOIN profesor pr ON a.id_profesor = pr.id_profesor WHERE pr.id_profesor IS NULL;
-- 6.
SELECT d.nombre FROM departamento d LEFT JOIN profesor pr ON d.id = pr.id_departamento LEFT JOIN asignatura a ON pr.id_profesor = a.id_profesor LEFT JOIN alumno_se_matricula_asignatura asm ON a.id = asm.id_asignatura WHERE asm.id_asignatura IS NULL;

-- Consultas resumen:
-- 1. 
SELECT COUNT(*) AS total_alumnos FROM persona;
-- 2. 
SELECT COUNT(*) AS alumnos_1999 FROM persona WHERE YEAR(fecha_nacimiento) = 1999;
-- 3. 
SELECT d.nombre AS nombre_departamento, COUNT(pr.id_profesor) AS num_profesores FROM departamento d LEFT JOIN profesor pr ON d.id = pr.id_departamento GROUP BY d.nombre ORDER BY num_profesores DESC;
-- 4. 
SELECT d.nombre AS nombre_departamento, COUNT(pr.id_profesor) AS num_profesores FROM departamento d LEFT JOIN profesor pr ON d.id = pr.id_departamento GROUP BY d.nombre;
-- 5. 
SELECT g.nombre AS nombre_grado, COUNT(a.id) AS num_asignaturas FROM grado g LEFT JOIN asignatura a ON g.id = a.id_grado GROUP BY g.nombre ORDER BY num_asignaturas DESC;
-- 6. 
SELECT g.nombre AS nombre_grado, COUNT(a.id) AS num_asignaturas FROM grado g LEFT JOIN asignatura a ON g.id = a.id_grado GROUP BY g.nombre HAVING num_asignaturas > 40;
-- 7. 
SELECT g.nombre AS nombre_grado, a.tipo, SUM(a.creditos) AS suma_creditos FROM grado g LEFT JOIN asignatura a ON g.id = a.id_grado GROUP BY g.nombre, a.tipo;
-- 8. 
SELECT YEAR(ce.anyo_inicio) AS año_inicio_curso, COUNT(asm.id_alumno) AS num_alumnos_matriculados FROM curso_escolar ce LEFT JOIN alumno_se_matricula_asignatura asm ON ce.id = asm.id_curso_escolar GROUP BY año_inicio_curso;
-- 9. 
SELECT p.id, p.nombre, p.apellido1, p.apellido2, COUNT(a.id) AS num_asignaturas FROM persona p LEFT JOIN profesor pr ON p.id = pr.id_profesor LEFT JOIN asignatura a ON pr.id_profesor = a.id_profesor GROUP BY p.id, p.nombre, p.apellido1, p.apellido2 ORDER BY num_asignaturas DESC;
-- 10. 
SELECT * FROM persona ORDER BY fecha_nacimiento DESC LIMIT 1;
-- 11. 
SELECT p.id, p.nombre, p.apellido1, p.apellido2 FROM persona p JOIN profesor pr ON p.id = pr.id_profesor JOIN departamento d ON pr.id_departamento = d.id LEFT JOIN asignatura a ON pr.id_profesor = a.id_profesor WHERE a.id_profesor IS NULL;


