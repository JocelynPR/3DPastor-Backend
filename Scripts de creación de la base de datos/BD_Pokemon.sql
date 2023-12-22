-- MySQL Script generated by MySQL Workbench
-- Thu Dec 21 18:08:47 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema pokemon_place
-- -----------------------------------------------------
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`roles` ;

CREATE TABLE IF NOT EXISTS `mydb`.`roles` (
  `rol_id` BIGINT NOT NULL AUTO_INCREMENT,
  `rol_nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`rol_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usuarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`usuarios` ;

CREATE TABLE IF NOT EXISTS `mydb`.`usuarios` (
  `usuario_id` BIGINT NOT NULL AUTO_INCREMENT,
  `usuario_nombre` VARCHAR(120) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `telefono` VARCHAR(15) NOT NULL,
  `contrasena` VARCHAR(20) NOT NULL,
  `direccion` VARCHAR(150) NULL,
  `rol_id` VARCHAR(45) NOT NULL,
  `roles_rol_id` INT NOT NULL,
  PRIMARY KEY (`usuario_id`, `roles_rol_id`),
  CONSTRAINT `fk_usuarios_roles`
    FOREIGN KEY (`roles_rol_id`)
    REFERENCES `mydb`.`roles` (`rol_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_usuarios_roles_idx` ON `mydb`.`usuarios` (`roles_rol_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`estado_compra`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`estado_compra` ;

CREATE TABLE IF NOT EXISTS `mydb`.`estado_compra` (
  `estado_id` BIGINT NOT NULL AUTO_INCREMENT,
  `estado_compra` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`estado_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`compras`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`compras` ;

CREATE TABLE IF NOT EXISTS `mydb`.`compras` (
  `compras_id` BIGINT NOT NULL AUTO_INCREMENT,
  `usuario_id` BIGINT NOT NULL,
  `fecha_compra` TIMESTAMP NULL,
  `estado_:id` BIGINT NOT NULL,
  PRIMARY KEY (`compras_id`),
  CONSTRAINT `usuario_id`
    FOREIGN KEY (`usuario_id`)
    REFERENCES `mydb`.`usuarios` (`usuario_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `estado_id`
    FOREIGN KEY (`estado_:id`)
    REFERENCES `mydb`.`estado_compra` (`estado_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `usuario_id_idx` ON `mydb`.`compras` (`usuario_id` ASC) VISIBLE;

CREATE INDEX `estado_id_idx` ON `mydb`.`compras` (`estado_:id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`productos` ;

CREATE TABLE IF NOT EXISTS `mydb`.`productos` (
  `producto_id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre_producto` VARCHAR(200) NOT NULL,
  `precio` DECIMAL(9,2) NOT NULL,
  `categoria_id` BIGINT NOT NULL,
  `imagen_id` BIGINT NOT NULL,
  `cantidad_disponible` INT NOT NULL,
  PRIMARY KEY (`producto_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`compras_has_productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`compras_has_productos` ;

CREATE TABLE IF NOT EXISTS `mydb`.`compras_has_productos` (
  `compras_id` BIGINT NOT NULL AUTO_INCREMENT,
  `productos_id` BIGINT NOT NULL,
  `cantidad_compra` INT NOT NULL,
  PRIMARY KEY (`compras_id`, `productos_id`),
  CONSTRAINT `compras_id`
    FOREIGN KEY (`compras_id`)
    REFERENCES `mydb`.`compras` (`compras_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `producto_id`
    FOREIGN KEY (`productos_id`)
    REFERENCES `mydb`.`productos` (`producto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `producto_id_idx` ON `mydb`.`compras_has_productos` (`productos_id` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `mydb`.`imagenes_productos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`imagenes_productos` ;

CREATE TABLE IF NOT EXISTS `mydb`.`imagenes_productos` (
  `imagen_id` BIGINT NOT NULL AUTO_INCREMENT,
  `nombre_imagen` VARCHAR(120) NOT NULL,
  `producto_id` BIGINT NOT NULL,
  PRIMARY KEY (`imagen_id`),
  CONSTRAINT `producto_id`
    FOREIGN KEY (`producto_id`)
    REFERENCES `mydb`.`productos` (`producto_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `producto_id_idx` ON `mydb`.`imagenes_productos` (`producto_id` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
