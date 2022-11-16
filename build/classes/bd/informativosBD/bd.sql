/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  YOBANY
 * Created: 12/11/2022
 */

-- ---- -------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`tipos_documentos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`tipos_documentos` ;

CREATE TABLE IF NOT EXISTS `mydb`.`tipos_documentos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`estados_civiles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`estados_civiles` ;

CREATE TABLE IF NOT EXISTS `mydb`.`estados_civiles` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`funcionarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`funcionarios` ;

CREATE TABLE IF NOT EXISTS `mydb`.`funcionarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `num_id` VARCHAR(45) NOT NULL,
  `nombres` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `sexo` CHAR(1) NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `fecha_nacimiento` DATE NOT NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tipos_documentos_id` INT NOT NULL,
  `estados_civiles_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `num_id_UNIQUE` (`num_id` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_funcionarios_tipos_documentos_idx` (`tipos_documentos_id` ASC) VISIBLE,
  INDEX `fk_funcionarios_estados_civiles1_idx` (`estados_civiles_id` ASC) VISIBLE,
  CONSTRAINT `fk_funcionarios_tipos_documentos`
    FOREIGN KEY (`tipos_documentos_id`)
    REFERENCES `mydb`.`tipos_documentos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionarios_estados_civiles1`
    FOREIGN KEY (`estados_civiles_id`)
    REFERENCES `mydb`.`estados_civiles` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`parentezcos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`parentezcos` ;

CREATE TABLE IF NOT EXISTS `mydb`.`parentezcos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`familiares_funcionarios`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`familiares_funcionarios` ;

CREATE TABLE IF NOT EXISTS `mydb`.`familiares_funcionarios` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `funcionarios_id` INT NOT NULL,
  `parentezcos_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_familiares_funcionarios_funcionarios1_idx` (`funcionarios_id` ASC) VISIBLE,
  INDEX `fk_familiares_funcionarios_parentezcos1_idx` (`parentezcos_id` ASC) VISIBLE,
  CONSTRAINT `fk_familiares_funcionarios_funcionarios1`
    FOREIGN KEY (`funcionarios_id`)
    REFERENCES `mydb`.`funcionarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_familiares_funcionarios_parentezcos1`
    FOREIGN KEY (`parentezcos_id`)
    REFERENCES `mydb`.`parentezcos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`niveles_educativos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`niveles_educativos` ;

CREATE TABLE IF NOT EXISTS `mydb`.`niveles_educativos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`universidades`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`universidades` ;

CREATE TABLE IF NOT EXISTS `mydb`.`universidades` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`formaciones_academicas`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`formaciones_academicas` ;

CREATE TABLE IF NOT EXISTS `mydb`.`formaciones_academicas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre_titulo` VARCHAR(45) NOT NULL,
  `fecha_actualizacion` VARCHAR(45) NOT NULL,
  `fecha_inicio` DATE NOT NULL,
  `fecha_fin` DATE NULL,
  `fecha_creacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `fecha_actualizacion` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `funcionarios_id` INT NOT NULL,
  `universidades_id` INT NOT NULL,
  `niveles_educativos_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_formaciones_academicas_funcionarios1_idx` (`funcionarios_id` ASC) VISIBLE,
  INDEX `fk_formaciones_academicas_universidades1_idx` (`universidades_id` ASC) VISIBLE,
  INDEX `fk_formaciones_academicas_niveles_educativos1_idx` (`niveles_educativos_id` ASC) VISIBLE,
  CONSTRAINT `fk_formaciones_academicas_funcionarios1`
    FOREIGN KEY (`funcionarios_id`)
    REFERENCES `mydb`.`funcionarios` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_formaciones_academicas_universidades1`
    FOREIGN KEY (`universidades_id`)
    REFERENCES `mydb`.`universidades` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_formaciones_academicas_niveles_educativos1`
    FOREIGN KEY (`niveles_educativos_id`)
    REFERENCES `mydb`.`niveles_educativos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

