-- Resources

-- Lista el total de facturas de un cliente/a en un período determinado.
SELECT customer_id, COUNT(*) AS total_invoices
FROM Sales
WHERE customer_id = 2 AND sale_date BETWEEN '2023-02-15' AND '2023-02-20'
GROUP BY customer_id;

-- Lista los diferentes modelos de gafas que ha vendido un empleado durante un año.
SELECT DISTINCT Glasses.brand
FROM Sales
JOIN Glasses ON Sales.glass_id = Glasses.glass_id
JOIN Employees ON Sales.employee_id = Employees.employee_id
WHERE Employees.employee_id = 5 AND YEAR(sale_date) = 2023;

-- Lista a los diferentes proveedores que han suministrado gafas vendidas con éxito por la óptica.
SELECT DISTINCT Suppliers.name
FROM Sales
JOIN Glasses ON Sales.glass_id = Glasses.glass_id
JOIN Suppliers ON Glasses.supplier_id = Suppliers.supplier_id;
