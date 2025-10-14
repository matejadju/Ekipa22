-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ris
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ris
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ris` DEFAULT CHARACTER SET utf8 ;
USE `ris` ;

-- -----------------------------------------------------
-- Table `ris`.`uporabnik`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ris`.`uporabnik` ;

CREATE TABLE IF NOT EXISTS `ris`.`uporabnik` (
  `iduporabnik` INT NOT NULL AUTO_INCREMENT,
  `ime` VARCHAR(45) NOT NULL,
  `priimek` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `geslo` VARCHAR(255) NOT NULL,
  `vrsta`  VARCHAR(50) NULL,
  `telefon` INT NOT NULL,
  `emso` INT NULL,
  `davcnaStevilka` INT NULL,
  PRIMARY KEY (`iduporabnik`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ris`.`tip_kluba`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ris`.`tip_kluba` ;

CREATE TABLE IF NOT EXISTS `ris`.`tip_kluba` (
  `idtip_kluba` INT NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(45) NOT NULL,
  `opis` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtip_kluba`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ris`.`klub`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ris`.`klub` ;

CREATE TABLE IF NOT EXISTS `ris`.`klub` (
  `idklub` INT NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(45) NOT NULL,
  `adresa` VARCHAR(45) NOT NULL,
  `telefon` INT NOT NULL,
  `PIB` INT NOT NULL,
  `status` TINYINT NOT NULL,
  `uporabnik_iduporabnik` INT NULL,
  `tip_kluba_idtip_kluba` INT NOT NULL,
  PRIMARY KEY (`idklub`),
  INDEX `fk_klub_uporabnik_idx` (`uporabnik_iduporabnik` ASC) VISIBLE,
  INDEX `fk_klub_tip_kluba1_idx` (`tip_kluba_idtip_kluba` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ris`.`rezervacija`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ris`.`rezervacija` ;

CREATE TABLE IF NOT EXISTS `ris`.`rezervacija` (
  `idrezervacija` INT NOT NULL AUTO_INCREMENT,
  `datum` DATE NOT NULL,
  `steviloOseb` INT NOT NULL,
  `poruka` VARCHAR(255) NULL,
  `uporabnik_iduporabnik` INT NOT NULL,
  PRIMARY KEY (`idrezervacija`),
  INDEX `fk_rezervacija_uporabnik1_idx` (`uporabnik_iduporabnik` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ris`.`tip_mize`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ris`.`tip_mize` ;

CREATE TABLE IF NOT EXISTS `ris`.`tip_mize` (
  `idtip_mize` INT NOT NULL AUTO_INCREMENT,
  `steviloOseb` INT NOT NULL,
  `naziv` VARCHAR(45) NOT NULL,
  `opis` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtip_mize`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ris`.`dogodek`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ris`.`dogodek` ;

CREATE TABLE IF NOT EXISTS `ris`.`dogodek` (
  `iddogodek` INT NOT NULL AUTO_INCREMENT,
  `datum` DATETIME NOT NULL,
  `naziv` VARCHAR(45) NOT NULL,
  `opis` VARCHAR(255) NOT NULL,
  `cenaVstopnice` DECIMAL NOT NULL,
  `steviloVstopnica` INT NOT NULL,
  `steviloMiz` INT NOT NULL,
  `klub_idklub` INT NULL,
  `uporabnik_iduporabnik` INT NULL,
  PRIMARY KEY (`iddogodek`),
  INDEX `fk_dogodek_klub1_idx` (`klub_idklub` ASC) VISIBLE,
  INDEX `fk_dogodek_uporabnik1_idx` (`uporabnik_iduporabnik` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ris`.`miza`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ris`.`miza` ;

CREATE TABLE IF NOT EXISTS `ris`.`miza` (
  `idmiza` INT NOT NULL AUTO_INCREMENT,
  `status` TINYINT NOT NULL,
  `tip_mize_idtip_mize` INT NOT NULL,
  `rezervacija_idrezervacija` INT NOT NULL,
  `dogodek_iddogodek` INT NOT NULL,
  PRIMARY KEY (`idmiza`),
  INDEX `fk_miza_tip_mize1_idx` (`tip_mize_idtip_mize` ASC) VISIBLE,
  INDEX `fk_miza_rezervacija1_idx` (`rezervacija_idrezervacija` ASC) VISIBLE,
  INDEX `fk_miza_dogodek1_idx` (`dogodek_iddogodek` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ris`.`recenzija`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ris`.`recenzija` ;

CREATE TABLE IF NOT EXISTS `ris`.`recenzija` (
  `idrecenzija` INT NOT NULL AUTO_INCREMENT,
  `ocena` INT NOT NULL,
  `tekst` VARCHAR(255) NOT NULL,
  `klub_idklub` INT NOT NULL,
  PRIMARY KEY (`idrecenzija`),
  INDEX `fk_recenzija_klub1_idx` (`klub_idklub` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ris`.`uporabnik_has_recenzija`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ris`.`uporabnik_has_recenzija` ;

CREATE TABLE IF NOT EXISTS `ris`.`uporabnik_has_recenzija` (
  `iduporabnik_has_recenzija` int NOT NULL AUTO_INCREMENT,
  `uporabnik_iduporabnik` INT not NULL,
  `recenzija_idrecenzija` INT not NULL,
  INDEX `fk_uporabnik_has_recenzija_recenzija1_idx` (`recenzija_idrecenzija` ASC) VISIBLE,
  INDEX `fk_uporabnik_has_recenzija_uporabnik1_idx` (`uporabnik_iduporabnik` ASC) VISIBLE,
  PRIMARY KEY (`iduporabnik_has_recenzija`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ris`.`vstopnice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `ris`.`vstopnice` ;

CREATE TABLE IF NOT EXISTS `ris`.`vstopnice` (
  `idvstopnice` INT NOT NULL AUTO_INCREMENT,
  `datum` DATE NOT NULL,
  `cena` INT NOT NULL,
  `dogodek_iddogodek` INT NOT NULL,
  PRIMARY KEY (`idvstopnice`),
  INDEX `fk_vstopnice_dogodek1_idx` (`dogodek_iddogodek` ASC) VISIBLE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
