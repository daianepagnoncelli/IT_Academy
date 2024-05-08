
-- -----------------------------------------------------
-- Table `opticsdb`.`Suppliers`
-- -----------------------------------------------------
CREATE TABLE Suppliers (
    supplier_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    street VARCHAR(255),
    number VARCHAR(10),
    floor VARCHAR(10),
    door VARCHAR(10),
    city VARCHAR(100),
    postal_code VARCHAR(20),
    country VARCHAR(100),
    phone VARCHAR(20),
    fax VARCHAR(20),
    NIF VARCHAR(20)
);

-- -----------------------------------------------------
-- Table `opticsdb`.`Glasses`
-- -----------------------------------------------------

CREATE TABLE Glasses (
    glass_id INT AUTO_INCREMENT PRIMARY KEY,
    supplier_id INT,
    brand VARCHAR(255),
    prescription VARCHAR(100),
    mount_type VARCHAR(50),
    mount_color VARCHAR(50),
    glass_color VARCHAR(50),
    price DECIMAL(10,2),
    FOREIGN KEY (supplier_id) REFERENCES Suppliers(supplier_id)
);

-- -----------------------------------------------------
-- Table `opticsdb`.`Customers`
-- -----------------------------------------------------

CREATE TABLE Customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    postal_address VARCHAR(255),
    phone VARCHAR(20),
    email VARCHAR(255),
    registration_date DATE,
    recommended_by INT,
    FOREIGN KEY (recommended_by) REFERENCES Customers(customer_id)
);

-- -----------------------------------------------------
-- Table `opticsdb`.`Employees`
-- -----------------------------------------------------

CREATE TABLE Employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    role VARCHAR(100)
);

-- -----------------------------------------------------
-- Table `opticsdb`.`Sales`
-- -----------------------------------------------------

CREATE TABLE Sales (
    sale_id INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT,
    glass_id INT,
    employee_id INT,
    sale_date DATE,
    FOREIGN KEY (customer_id) REFERENCES Customers(customer_id),
    FOREIGN KEY (glass_id) REFERENCES Glasses(glass_id),
    FOREIGN KEY (employee_id) REFERENCES Employees(employee_id)
);
