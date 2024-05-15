-- 1. 
SELECT nombre FROM producto;
-- 2. 
SELECT nombre, precio FROM producto;
-- 3. 
SELECT * FROM producto;
-- 4. 
SELECT nombre, precio, precio * 1.18 AS "dólares" FROM producto;
--->5. 
SELECT nombre AS "nombre de producto", precio AS "euros", precio * 1.18 AS "dólares" FROM producto;
-- 6. 
SELECT UPPER(nombre), precio FROM producto;
-- 7. 
SELECT LOWER(nombre), precio FROM producto;
-- 8. 
SELECT nombre, UPPER(SUBSTRING(nombre FROM 1 FOR 2)) FROM fabricante;
-- 9. 
SELECT nombre, ROUND(precio) FROM producto;
-- 10. 
SELECT nombre, TRUNCATE(precio, 0) FROM producto;
-- 11. 
SELECT p.codigo_fabricante FROM producto p;
---> 12. 
SELECT DISTINCT p.codigo_fabricante FROM producto p;
-- 13. 
SELECT nombre FROM fabricante ORDER BY nombre ASC;
-- 14. 
SELECT nombre FROM fabricante ORDER BY nombre DESC;
-- 15. 
SELECT nombre, precio FROM producto ORDER BY nombre ASC, precio DESC;
-- 16. 
SELECT * FROM fabricante LIMIT 5;
-- 17. 
SELECT * FROM fabricante LIMIT 2 OFFSET 3;
-- 18. 
SELECT nombre, precio FROM producto ORDER BY precio LIMIT 1;
-- 19. 
SELECT nombre, precio FROM producto ORDER BY precio DESC LIMIT 1;
-- 20. 
SELECT nombre FROM producto WHERE codigo_fabricante = 2;
-- 21. 
SELECT p.nombre, p.precio, f.nombre AS nombre_fabricante FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo;
-- 22. 
SELECT p.nombre, p.precio, f.nombre AS nombre_fabricante FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo ORDER BY f.nombre ASC;
-- 23. 
SELECT p.codigo, p.nombre AS nombre_producto, p.codigo_fabricante, f.nombre AS nombre_fabricante FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo;
-- 24. 
SELECT p.nombre, p.precio, f.nombre AS nombre_fabricante FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo ORDER BY p.precio ASC LIMIT 1;
-- 25. 
SELECT p.nombre, p.precio, f.nombre AS nombre_fabricante FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo ORDER BY p.precio DESC LIMIT 1;
-- 26. 
SELECT p.nombre, p.precio FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo WHERE f.nombre = 'Lenovo';
--27. 
SELECT p.nombre, p.precio FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo WHERE f.nombre = 'Crucial' AND p.precio > 200;
-- 28. 
SELECT p.nombre, p.precio FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo WHERE f.nombre = 'Asus' OR f.nombre = 'Hewlett-Packard' OR f.nombre = 'Seagate';
-- 29. 
SELECT p.nombre, p.precio FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo WHERE f.nombre IN ('Asus', 'Hewlett-Packard', 'Seagate');
-- 30. 
SELECT p.nombre, p.precio FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo WHERE f.nombre LIKE '%e';
-- 31. 
SELECT p.nombre, p.precio FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo WHERE f.nombre LIKE '%w%';
-- 32. 
SELECT p.nombre, p.precio, f.nombre AS nombre_fabricante FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo WHERE p.precio >= 180 ORDER BY p.precio DESC, p.nombre ASC;
-- 33. 
SELECT f.codigo, f.nombre FROM fabricante f JOIN producto p ON f.codigo = p.codigo_fabricante GROUP BY f.codigo, f.nombre;
-- 34. 
SELECT f.codigo, f.nombre, COUNT(p.codigo) AS cantidad_productos FROM fabricante f LEFT JOIN producto p ON f.codigo = p.codigo_fabricante GROUP BY f.codigo, f.nombre;
-- 35. 
SELECT f.codigo, f.nombre FROM fabricante f LEFT JOIN producto p ON f.codigo = p.codigo_fabricante WHERE p.codigo_fabricante IS NULL;
-- 36. 
SELECT nombre, precio FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Lenovo');
-- 37. 
SELECT * FROM producto WHERE precio = ( SELECT MAX(precio) FROM producto WHERE codigo_fabricante = ( SELECT codigo FROM fabricante WHERE nombre = 'Lenovo'));
-- 38. 
SELECT nombre FROM producto WHERE codigo_fabricante = ( SELECT codigo FROM fabricante WHERE nombre = 'Lenovo') ORDER BY precio DESC LIMIT 1;
-- 39. 
SELECT nombre FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Hewlett-Packard') ORDER BY precio ASC LIMIT 1;
-- 40. 
SELECT * FROM producto WHERE precio >= (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = ( SELECT codigo FROM fabricante WHERE nombre = 'Lenovo'));
-- 41. 
SELECT p.nombre, p.precio FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo WHERE f.nombre = 'Asus' AND p.precio > (SELECT AVG(precio) FROM producto WHERE codigo_fabricante = f.codigo);
