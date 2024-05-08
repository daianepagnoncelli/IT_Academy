CREATE TABLE Provinces (
    province_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE Localities (
    locality_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    province_id INT,
    FOREIGN KEY (province_id) REFERENCES Provinces(province_id)
);

CREATE TABLE Customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    address VARCHAR(255),
    postal_code VARCHAR(20),
    locality_id INT,
    phone_number VARCHAR(20),
    FOREIGN KEY (locality_id) REFERENCES Localities(locality_id)
);

CREATE TABLE Categories (
    category_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100)
);

CREATE TABLE Products (
    product_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    description TEXT,
    image VARCHAR(255),
    price DECIMAL(10, 2),
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES Categories(category_id)
);

CREATE TABLE Stores (
    store_id INT AUTO_INCREMENT PRIMARY KEY,
    address VARCHAR(255),
    postal_code VARCHAR(20),
    locality_id INT,
    FOREIGN KEY (locality_id) REFERENCES Localities(locality_id)
);

CREATE TABLE Employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    NIF VARCHAR(20),
    phone VARCHAR(20),
    role VARCHAR(50),
    store_id INT,
    FOREIGN KEY (store_id) REFERENCES Stores(store_id)
);

CREATE TABLE Orders (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    order_datetime DATETIME,
    delivery_type ENUM('home_delivery', 'store_pickup'),
    total_price DECIMAL(10, 2),
    FOREIGN KEY (store_id) REFERENCES Stores(store_id),
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (employee_id) REFERENCES Employees(employee_id)
);

CREATE TABLE OrderDetails (
    order_detail_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    product_id INT,
    quantity INT,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (product_id) REFERENCES Products(product_id)
);

CREATE TABLE Deliveries (
    delivery_id INT AUTO_INCREMENT PRIMARY KEY,
    order_id INT,
    employee_id INT,
    delivery_datetime DATETIME,
    FOREIGN KEY (order_id) REFERENCES Orders(order_id),
    FOREIGN KEY (employee_id) REFERENCES Employees(employee_id)
);

