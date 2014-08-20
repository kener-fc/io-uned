SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema iouned
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `iouned` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `iouned` ;

-- -----------------------------------------------------
-- Table `iouned`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iouned`.`Cliente` (
  `idCliente` INT NOT NULL,
  `nombre` VARCHAR(35) NULL,
  `apellido1` VARCHAR(35) NULL,
  `apellido2` VARCHAR(35) NULL,
  PRIMARY KEY (`idCliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `iouned`.`Credito`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iouned`.`Credito` (
  `idCredito` VARCHAR(50) NOT NULL,
  `idCliente` INT NOT NULL,
  `monto` DECIMAL(2) NULL,
  `fecFormalizacion` DATE NULL,
  `interes` DECIMAL(2) NULL,
  `plazo` INT NULL,
  PRIMARY KEY (`idCredito`),
  INDEX `fk_Credito_Cliente_idx` (`idCliente` ASC),
  CONSTRAINT `fk_Credito_Cliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `iouned`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `iouned`.`Abono`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `iouned`.`Abono` (
  `idAbono` INT NOT NULL,
  `idCredito` VARCHAR(50) NOT NULL,
  `fecAbono` DATE NULL,
  `monto` DECIMAL(2) NULL,
  PRIMARY KEY (`idAbono`),
  INDEX `fk_Abono_Credito1_idx` (`idCredito` ASC),
  CONSTRAINT `fk_Abono_Credito1`
    FOREIGN KEY (`idCredito`)
    REFERENCES `iouned`.`Credito` (`idCredito`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
