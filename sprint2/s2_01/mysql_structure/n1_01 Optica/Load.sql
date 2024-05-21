
-- Table Suppliers
INSERT INTO Suppliers (name, street, number, floor, door, city, postal_code, country, phone, fax, NIF)
VALUES 
('Supplier 1', 'Street 1', '123', '2', 'A', 'City A', '12345', 'Country A', '123456789', '123456789', '123ABC'),
('Supplier 2', 'Street 2', '456', '3', 'B', 'City B', '23456', 'Country B', '987654321', '987654321', '456DEF'),
('Supplier 3', 'Street 3', '789', '4', 'C', 'City C', '34567', 'Country C', '456789012', '456789012', '789GHI');

-- Table Glasses
INSERT INTO Glasses (supplier_id, brand, prescription, mount_type, mount_color, glass_color, price)
VALUES 
(1, 'Brand 1', '+2.00', 'Floating', 'Black', 'Clear', 50.00),
(2, 'Brand 2', '-1.50', 'Paste', 'Brown', 'Brown', 45.00),
(3, 'Brand 3', '0.00', 'Metallic', 'Silver', 'Gray', 60.00);

-- Table Customers
INSERT INTO Customers (name, postal_address, phone, email, registration_date, recommended_by)
VALUES 
('Customer 1', 'Address 1', '123456789', 'customer1@example.com', '2023-01-01', NULL),
('Customer 2', 'Address 2', '987654321', 'customer2@example.com', '2023-02-15', 1),
('Customer 3', 'Address 3', '456789012', 'customer3@example.com', '2023-03-20', 2);

-- Table Employees
INSERT INTO Employees (name, role)
VALUES 
('Employee 1', 'Salesperson'),
('Employee 2', 'Manager'),
('Employee 3', 'Assistant');

-- Table Sales
INSERT INTO Sales (customer_id, glass_id, employee_id, sale_date)
VALUES 
(1, 1, 1, '2023-01-05'),
(2, 2, 2, '2023-02-20'),
(3, 3, 3, '2023-03-25');
