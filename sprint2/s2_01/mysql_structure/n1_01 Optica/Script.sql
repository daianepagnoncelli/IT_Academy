CREATE DATABASE `opticsdb` DEFAULT CHARACTER SET utf8mb4;
USE `opticsdb`;

-- -----------------------------------------------------
-- Table `opticsdb`.`suppliers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `suppliers` (
    `supplierId` TINYINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `address` VARCHAR(80) NULL,
    `phone` VARCHAR(50) NULL,
    `fax` VARCHAR(50) NULL,
    `NIF` VARCHAR(9),
    PRIMARY KEY(`supplierId`)
) ENGINE = InnoDB 
DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `opticsdb`.`brands`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `brands` (
    `brandId` TINYINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `idSupplier` TINYINT,
    PRIMARY KEY(`brandId`),
    FOREIGN KEY (`idSupplier`) 
        REFERENCES `suppliers` (`supplierId`)
        ON DELETE NO ACTION 
        ON UPDATE NO ACTION
) ENGINE = InnoDB 
DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `opticsdb`.`glasses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `glasses` (
    `glassesId` TINYINT NOT NULL AUTO_INCREMENT,
    `idBrand` TINYINT NOT NULL,
    `prescriptionL` ENUM("0.00", "+0.25", "-0.25", "+0.50", "-0.50", "+0.75", "-0.75", "+1.00", "-1.00", "+1.25", "-1.25", "+1.50", "-1.50", "+1.75", "-1.75", "+2.00", "-2.00", "+2.25", "-2.25", "+2.50", "-2.50", "+2.75", "-2.75", "+3.00", "-3.00") NOT NULL,
    `prescriptionR` ENUM("0.00", "+0.25", "-0.25", "+0.50", "-0.50", "+0.75", "-0.75", "+1.00", "-1.00", "+1.25", "-1.25", "+1.50", "-1.50", "+1.75", "-1.75", "+2.00", "-2.00", "+2.25", "-2.25", "+2.50", "-2.50", "+2.75", "-2.75", "+3.00", "-3.00")  NOT NULL,
    `frame` ENUM("rimless", "resin", "metal") NOT NULL,
    `frameColour` VARCHAR(50) NOT NULL,
    `glassColourL` VARCHAR(50) NOT NULL,
    `glassColourR` VARCHAR(50) NOT NULL,
    `price` FLOAT NOT NULL,
    PRIMARY KEY(`glassesId`),
    FOREIGN KEY (`idBrand`) 
        REFERENCES `brands` (`brandId`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
) ENGINE = InnoDB 
DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `opticsdb`.`customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `customers` (
    `customerId` TINYINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `address` VARCHAR(50),
    `phone` VARCHAR(50) NOT NULL,
    `email` VARCHAR(80) NOT NULL,
    `registerDate` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `idRecomendedFor` TINYINT,
    PRIMARY KEY(`customerId`),
    FOREIGN KEY (`idRecomendedFor`) 
        REFERENCES `customers` (`customerId`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
) ENGINE = InnoDB 
DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `opticsdb`.`sellers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sellers` (
    `sellerId` TINYINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    PRIMARY KEY(`sellerId`)
) ENGINE = InnoDB 
DEFAULT CHARACTER SET = utf8mb4;

-- -----------------------------------------------------
-- Table `opticsdb`.`purchases`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `purchases` (
    `purchaseId` TINYINT NOT NULL AUTO_INCREMENT,
    `idCustomer` TINYINT NOT NULL,
    `idGlasses` TINYINT NOT NULL,
    `idSeller` TINYINT NOT NULL,
    `purchaseDate` DATE NOT NULL,
    PRIMARY KEY(`purchaseId`),
    FOREIGN KEY (`idCustomer`) 
        REFERENCES `customers` (`customerId`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    FOREIGN KEY (`idGlasses`) 
        REFERENCES `glasses` (`glassesId`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION,
    FOREIGN KEY (`idSeller`) 
        REFERENCES `sellers` (`sellerId`)
        ON DELETE NO ACTION
        ON UPDATE NO ACTION
) ENGINE = InnoDB 
DEFAULT CHARACTER SET = utf8mb4;





