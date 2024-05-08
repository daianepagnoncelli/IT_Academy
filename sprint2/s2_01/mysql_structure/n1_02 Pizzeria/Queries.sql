-- Resources

SELECT COUNT(od.quantity) AS total_beverages_sold
FROM Orders o
INNER JOIN OrderDetails od ON o.order_id = od.order_id
INNER JOIN Products p ON od.product_id = p.product_id
INNER JOIN Categories c ON p.category_id = c.category_id
INNER JOIN Stores s ON o.store_id = s.store_id
INNER JOIN Localities l ON s.locality_id = l.locality_id
WHERE c.name = 'Beverages'
AND l.name = 'Localidade 6';


SELECT COUNT(o.order_id) AS total_orders_placed
FROM Orders o
INNER JOIN Employees e ON o.employee_id = e.employee_id
WHERE e.employee_id = 34;

