USE `opticsdb`;

-- Insert data into `suppliers`
INSERT INTO `suppliers` (`name`, `address`, `phone`, `fax`, `NIF`) VALUES
('Tatooine Traders', 'Mos Eisley, Tatooine', '123-456-789', '123-456-780', '123456789'),
('Hoth Supply Co.', 'Echo Base, Hoth', '234-567-890', '234-567-891', '234567890'),
('Endor Supplies', 'Bright Tree Village, Endor', '345-678-901', '345-678-902', '345678901');

-- Insert data into `brands`
INSERT INTO `brands` (`name`, `idSupplier`) VALUES
('Skywalker', 1),
('Solo', 2),
('Organa', 3);

-- Insert data into `glasses`
INSERT INTO `glasses` (`idBrand`, `prescriptionL`, `prescriptionR`, `frame`, `frameColour`, `glassColourL`, `glassColourR`, `price`) VALUES
(1, '0.00', '-1.00', 'rimless', 'black', 'clear', 'clear', 150.00),
(2, '+0.50', '+0.50', 'resin', 'blue', 'clear', 'clear', 200.00),
(3, '-0.75', '-0.75', 'metal', 'silver', 'tinted', 'tinted', 250.00);

-- Insert data into `customers`
INSERT INTO `customers` (`name`, `address`, `phone`, `email`, `idRecomendedFor`) VALUES
('Luke Skywalker', 'Anchorhead, Tatooine', '111-222-333', 'luke@jedi.com', NULL),
('Leia Organa', 'Alderaan', '444-555-666', 'leia@rebel.com', 1),
('Han Solo', 'Millennium Falcon', '777-888-999', 'han@smuggler.com', 1),
('Chewbacca', 'Kashyyyk', '000-111-222', 'chewie@wookiee.com', 3);

-- Insert data into `sellers`
INSERT INTO `sellers` (`name`) VALUES
('Obi-Wan Kenobi'),
('Yoda'),
('Darth Vader'),
('Leia');

-- Insert data into `purchases`
INSERT INTO `purchases` (`idCustomer`, `idGlasses`, `idSeller`, `purchaseDate`) VALUES
(1, 1, 1, '2023-05-01'),
(2, 2, 2, '2023-05-02'),
(3, 3, 3, '2023-05-03'),
(4, 1, 1, '2023-05-04'),
(1, 1, 4, '2024-05-01'),
(2, 2, 4, '2024-06-15'),
(3, 3, 4, '2024-07-20');
