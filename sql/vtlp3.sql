-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`especie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`especie` ;

CREATE TABLE IF NOT EXISTS `mydb`.`especie` (
  `idespecie` INT NOT NULL,
  `descricao` VARCHAR(45) NULL,
  `nome_cientifico` VARCHAR(45) NULL,
  PRIMARY KEY (`idespecie`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`proprietario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`proprietario` ;

CREATE TABLE IF NOT EXISTS `mydb`.`proprietario` (
  `idproprietario` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `endereco` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  `cpf` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idproprietario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`raca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`raca` ;

CREATE TABLE IF NOT EXISTS `mydb`.`raca` (
  `idraca` INT NOT NULL,
  `descricao` VARCHAR(45) NULL,
  `id_especie` INT NULL,
  PRIMARY KEY (`idraca`),
  CONSTRAINT `fk_especie`
    FOREIGN KEY (`id_especie`)
    REFERENCES `mydb`.`especie` (`idespecie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_especie_idx` ON `mydb`.`raca` (`id_especie` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`exame`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`exame` ;

CREATE TABLE IF NOT EXISTS `mydb`.`exame` (
  `idexame` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `area` VARCHAR(45) NULL,
  PRIMARY KEY (`idexame`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`item` ;

CREATE TABLE IF NOT EXISTS `mydb`.`item` (
  `iditem` INT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `referencia` VARCHAR(45) NULL,
  `id_exame` INT NOT NULL,
  PRIMARY KEY (`iditem`),
  CONSTRAINT `fk_exame`
    FOREIGN KEY (`id_exame`)
    REFERENCES `mydb`.`exame` (`idexame`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `iditem_UNIQUE` ON `mydb`.`item` (`iditem` ASC);

CREATE INDEX `fk_exame_idx` ON `mydb`.`item` (`id_exame` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`pet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`pet` ;

CREATE TABLE IF NOT EXISTS `mydb`.`pet` (
  `idpet` INT NOT NULL,
  `descricao` VARCHAR(45) NULL,
  `data_nascimento` DATE NULL,
  `id_raca` INT NOT NULL,
  `id_proprietario` INT NOT NULL,
  PRIMARY KEY (`idpet`),
  CONSTRAINT `fk_raca`
    FOREIGN KEY (`id_raca`)
    REFERENCES `mydb`.`raca` (`idraca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_proprietario`
    FOREIGN KEY (`id_proprietario`)
    REFERENCES `mydb`.`proprietario` (`idproprietario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_raca_idx` ON `mydb`.`pet` (`id_raca` ASC);

CREATE INDEX `fk_proprietario_idx` ON `mydb`.`pet` (`id_proprietario` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`grupo_acesso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`grupo_acesso` ;

CREATE TABLE IF NOT EXISTS `mydb`.`grupo_acesso` (
  `idgrupo_acesso` INT NOT NULL,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`idgrupo_acesso`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`usuario` ;

CREATE TABLE IF NOT EXISTS `mydb`.`usuario` (
  `idusuario` INT NOT NULL,
  `username` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `id_grupo_acesso` INT NULL,
  `nome` VARCHAR(45) NULL,
  `endereco` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  `cpf` VARCHAR(45) NULL,
  PRIMARY KEY (`idusuario`),
  CONSTRAINT `fk_grupo_acesso`
    FOREIGN KEY (`id_grupo_acesso`)
    REFERENCES `mydb`.`grupo_acesso` (`idgrupo_acesso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_grupo_acesso_idx` ON `mydb`.`usuario` (`id_grupo_acesso` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`veterinario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`veterinario` ;

CREATE TABLE IF NOT EXISTS `mydb`.`veterinario` (
  `idveterinario` INT NOT NULL,
  `id_usuario` INT NULL,
  `crv` VARCHAR(45) NULL,
  `especialidade` VARCHAR(45) NULL,
  PRIMARY KEY (`idveterinario`),
  CONSTRAINT `fk_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `mydb`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_usuario_idx` ON `mydb`.`veterinario` (`id_usuario` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`prontuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`prontuario` ;

CREATE TABLE IF NOT EXISTS `mydb`.`prontuario` (
  `idprontuario` INT NOT NULL,
  `data` DATE NULL,
  `id_veterinario` INT NULL,
  `id_pet` INT NULL,
  `observacao` VARCHAR(45) NULL,
  `realizado` TINYINT(1) NULL,
  PRIMARY KEY (`idprontuario`),
  CONSTRAINT `fk_pet`
    FOREIGN KEY (`id_pet`)
    REFERENCES `mydb`.`pet` (`idpet`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_veterinario`
    FOREIGN KEY (`id_veterinario`)
    REFERENCES `mydb`.`veterinario` (`idveterinario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_pet_idx` ON `mydb`.`prontuario` (`id_pet` ASC);

CREATE INDEX `fk_veterinario_idx` ON `mydb`.`prontuario` (`id_veterinario` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`consulta_exame`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`consulta_exame` ;

CREATE TABLE IF NOT EXISTS `mydb`.`consulta_exame` (
  `idconsulta_exame` INT NOT NULL,
  `id_prontuario` INT NULL,
  `id_exame` INT NULL,
  PRIMARY KEY (`idconsulta_exame`),
  CONSTRAINT `fk_protuario`
    FOREIGN KEY (`id_prontuario`)
    REFERENCES `mydb`.`prontuario` (`idprontuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_exame`
    FOREIGN KEY (`id_exame`)
    REFERENCES `mydb`.`exame` (`idexame`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_exame_idx` ON `mydb`.`consulta_exame` (`id_exame` ASC);

CREATE INDEX `fk_protuario_idx` ON `mydb`.`consulta_exame` (`id_prontuario` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`resultado_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`resultado_item` ;

CREATE TABLE IF NOT EXISTS `mydb`.`resultado_item` (
  `idresultado_item` INT NOT NULL,
  `id_item` INT NOT NULL,
  PRIMARY KEY (`idresultado_item`),
  CONSTRAINT `fk_item`
    FOREIGN KEY (`id_item`)
    REFERENCES `mydb`.`item` (`iditem`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_item_idx` ON `mydb`.`resultado_item` (`id_item` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`Funcionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`Funcionario` ;

CREATE TABLE IF NOT EXISTS `mydb`.`Funcionario` (
  `idfuncionario` INT NOT NULL,
  `funcao` INT NULL,
  `id_usuario` INT NULL,
  PRIMARY KEY (`idfuncionario`),
  CONSTRAINT `fk_usuario`
    FOREIGN KEY (`id_usuario`)
    REFERENCES `mydb`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_usuario_idx` ON `mydb`.`Funcionario` (`id_usuario` ASC);


-- -----------------------------------------------------
-- Table `mydb`.`tipo_acesso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`tipo_acesso` ;

CREATE TABLE IF NOT EXISTS `mydb`.`tipo_acesso` (
  `idtipo_acesso` INT NOT NULL,
  `rotina` VARCHAR(45) NULL,
  `id_grupo_acesso` INT NULL,
  PRIMARY KEY (`idtipo_acesso`),
  CONSTRAINT `fk_grupo_acesso`
    FOREIGN KEY (`id_grupo_acesso`)
    REFERENCES `mydb`.`grupo_acesso` (`idgrupo_acesso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_grupo_acesso_idx` ON `mydb`.`tipo_acesso` (`id_grupo_acesso` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
