-- Table Provinces
INSERT INTO Provinces (name) VALUES 
('Província A'),
('Província B'),
('Província C');

-- Table Localities
INSERT INTO Localities (name, province_id) VALUES 
('Localidade 1', 1),
('Localidade 2', 1),
('Localidade 3', 2),
('Localidade 4', 2),
('Localidade 5', 3);

-- TAble Categories
INSERT INTO Categories (name) VALUES 
('Categoria 1'),
('Categoria 2'),
('Categoria 3');

-- Table Products
INSERT INTO Products (name, description, image, price, category_id) VALUES 
('Produto 1', 'Descrição do Produto 1', 'imagem_produto1.jpg', 10.99, 1),
('Produto 2', 'Descrição do Produto 2', 'imagem_produto2.jpg', 15.99, 2),
('Produto 3', 'Descrição do Produto 3', 'imagem_produto3.jpg', 20.99, 3);

-- Table Stores
INSERT INTO Stores (address, postal_code, locality_id) VALUES 
('Endereço 1', '12345', 1),
('Endereço 2', '23456', 2),
('Endereço 3', '34567', 3);

-- Table Employees
INSERT INTO Employees (first_name, last_name, NIF, phone, role, store_id) VALUES 
('Funcionário 1', 'Sobrenome 1', '123456789', '987654321', 'Cargo 1', 1),
('Funcionário 2', 'Sobrenome 2', '234567890', '876543210', 'Cargo 2', 2),
('Funcionário 3', 'Sobrenome 3', '345678901', '765432109', 'Cargo 3', 3);

-- Table Customers
INSERT INTO Customers (first_name, last_name, address, postal_code, locality_id, phone_number) VALUES 
('Cliente 1', 'Sobrenome 1', 'Endereço Cliente 1', '12345', 1, '987654321'),
('Cliente 2', 'Sobrenome 2', 'Endereço Cliente 2', '23456', 2, '876543210'),
('Cliente 3', 'Sobrenome 3', 'Endereço Cliente 3', '34567', 3, '765432109');

-- Table Orders
INSERT INTO Orders (customer_id, order_datetime, delivery_type, total_price) VALUES 
(1, '2024-05-03 14:30:00', 'home_delivery', 30.99),
(2, '2024-05-03 15:00:00', 'store_pickup', 25.99),
(3, '2024-05-03 15:30:00', 'home_delivery', 35.99);

-- Table OrderDetails
INSERT INTO OrderDetails (order_id, product_id, quantity) VALUES 
(1, 1, 2),
(1, 2, 1),
(2, 2, 3),
(3, 3, 1);

-- Table Deliveries
INSERT INTO Deliveries (order_id, employee_id, delivery_datetime) VALUES 
(1, 1, '2024-05-03 16:00:00'),
(2, 2, '2024-05-03 16:30:00'),
(3, 3, '2024-05-03 17:00:00');
