-- Resources

-- Lista el total de facturas de un cliente/a en un período determinado.
SELECT customers.name, SUM(glasses.price) AS "totalInvoices"
FROM opticsdb.purchases
INNER JOIN opticsdb.glasses ON purchases.idGlasses = glasses.glassesId
JOIN opticsdb.customers ON purchases.idCustomer = customers.customerId
WHERE purchases.purchaseDate BETWEEN '2023-01-01' AND '2023-12-31'
GROUP BY purchases.idCustomer;


-- Lista los diferentes modelos de gafas que ha vendido un empleado durante un año.
SELECT DISTINCT glasses.*
FROM opticsdb.purchases
INNER JOIN opticsdb.glasses ON purchases.idGlasses = glasses.glassesId
JOIN opticsdb.sellers ON purchases.idSeller = sellers.sellerId
WHERE sellers.name = 'Peter' AND purchases.purchaseDate BETWEEN '2024-01-01' AND '2024-12-31';


-- Lista a los diferentes proveedores que han suministrado gafas vendidas con éxito por la óptica.
SELECT DISTINCT suppliers.name, suppliers.address, suppliers.phone
FROM opticsdb.purchases
INNER JOIN opticsdb.glasses ON purchases.idGlasses = glasses.glassesId
JOIN opticsdb.brands ON glasses.idBrand = brands.brandId
JOIN opticsdb.suppliers ON brands.idSupplier = suppliers.supplierId;
