
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema veterinaria
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `veterinaria` ;

-- -----------------------------------------------------
-- Schema veterinaria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `veterinaria` DEFAULT CHARACTER SET utf8 ;
USE `veterinaria` ;

-- -----------------------------------------------------
-- Table `veterinaria`.`proprietario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `veterinaria`.`proprietario` ;

CREATE TABLE IF NOT EXISTS `veterinaria`.`proprietario` (
  `idproprietario` INT NOT NULL auto_increment,
  `nome` VARCHAR(45) NULL,
  `endereco` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  `cpf` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idproprietario`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `veterinaria`.`especie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `veterinaria`.`especie` ;

CREATE TABLE IF NOT EXISTS `veterinaria`.`especie` (
  `idespecie` INT NOT NULL auto_increment,
  `descricao` VARCHAR(45) NULL,
  `nome_cientifico` VARCHAR(45) NULL,
  PRIMARY KEY (`idespecie`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `veterinaria`.`raca`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `veterinaria`.`raca` ;

CREATE TABLE IF NOT EXISTS `veterinaria`.`raca` (
  `idraca` INT NOT NULL auto_increment,
  `descricao` VARCHAR(45) NULL,
  `id_raca_especie` INT NULL,
  PRIMARY KEY (`idraca`),
  CONSTRAINT `fk_especie`
    FOREIGN KEY (`id_raca_especie`)
    REFERENCES `veterinaria`.`especie` (`idespecie`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_especie_idx` ON `veterinaria`.`raca` (`id_raca_especie` ASC);


-- -----------------------------------------------------
-- Table `veterinaria`.`exame`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `veterinaria`.`exame` ;

CREATE TABLE IF NOT EXISTS `veterinaria`.`exame` (
  `idexame` INT NOT NULL auto_increment ,
  `nome` VARCHAR(45) NULL,
  `area` VARCHAR(45) NULL,
  PRIMARY KEY (`idexame`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `veterinaria`.`item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `veterinaria`.`item` ;

CREATE TABLE IF NOT EXISTS `veterinaria`.`item` (
  `iditem` INT NOT NULL auto_increment,
  `nome` VARCHAR(45) NULL,
  `referencia` VARCHAR(45) NULL,
  `id_item_exame` INT NOT NULL,
  PRIMARY KEY (`iditem`),
  CONSTRAINT `fk_exame_item`
    FOREIGN KEY (`id_item_exame`)
    REFERENCES `veterinaria`.`exame` (`idexame`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE UNIQUE INDEX `iditem_UNIQUE` ON `veterinaria`.`item` (`iditem` ASC);

CREATE INDEX `fk_exame_idx` ON `veterinaria`.`item` (`id_item_exame` ASC);


-- -----------------------------------------------------
-- Table `veterinaria`.`pet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `veterinaria`.`pet` ;

CREATE TABLE IF NOT EXISTS `veterinaria`.`pet` (
  `idpet` INT NOT NULL auto_increment,
  `descricao` VARCHAR(45) NULL,
  `data_nascimento` DATE NULL,
  `id_pet_raca` INT NOT NULL,
  `id_pet_proprietario` INT NOT NULL,
  PRIMARY KEY (`idpet`),
  CONSTRAINT `fk_raca`
    FOREIGN KEY (`id_pet_raca`)
    REFERENCES `veterinaria`.`raca` (`idraca`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_proprietario`
    FOREIGN KEY (`id_pet_proprietario`)
    REFERENCES `veterinaria`.`proprietario` (`idproprietario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_raca_idx` ON `veterinaria`.`pet` (`id_pet_raca` ASC);

CREATE INDEX `fk_proprietario_idx` ON `veterinaria`.`pet` (`id_pet_proprietario` ASC);


-- -----------------------------------------------------
-- Table `veterinaria`.`grupo_acesso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `veterinaria`.`grupo_acesso` ;

CREATE TABLE IF NOT EXISTS `veterinaria`.`grupo_acesso` (
  `idgrupo_acesso` INT NOT NULL auto_increment,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`idgrupo_acesso`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `veterinaria`.`usuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `veterinaria`.`usuario` ;

CREATE TABLE IF NOT EXISTS `veterinaria`.`usuario` (
  `idusuario` INT NOT NULL auto_increment,
  `username` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `id_usuario_grupo_acesso` INT NULL,
  `nome` VARCHAR(45) NULL,
  `endereco` VARCHAR(45) NULL,
  `telefone` VARCHAR(45) NULL,
  `cpf` VARCHAR(45) NULL,
  PRIMARY KEY (`idusuario`),
  CONSTRAINT `fk_grupo_acesso`
    FOREIGN KEY (`id_usuario_grupo_acesso`)
    REFERENCES `veterinaria`.`grupo_acesso` (`idgrupo_acesso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_grupo_acesso_idx` ON `veterinaria`.`usuario` (`id_usuario_grupo_acesso` ASC);


-- -----------------------------------------------------
-- Table `veterinaria`.`veterinario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `veterinaria`.`veterinario` ;

CREATE TABLE IF NOT EXISTS `veterinaria`.`veterinario` (
  `idveterinario` INT NOT NULL auto_increment,
  `id_veterinario_usuario` INT NULL,
  `crv` VARCHAR(45) NULL,
  `especialidade` VARCHAR(45) NULL,
  PRIMARY KEY (`idveterinario`),
  CONSTRAINT `fk_usuario`
    FOREIGN KEY (`id_veterinario_usuario`)
    REFERENCES `veterinaria`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_usuario_idx` ON `veterinaria`.`veterinario` (`id_veterinario_usuario` ASC);


-- -----------------------------------------------------
-- Table `veterinaria`.`prontuario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `veterinaria`.`prontuario` ;

CREATE TABLE IF NOT EXISTS `veterinaria`.`prontuario` (
  `idprontuario` INT NOT NULL auto_increment,
  `data` DATE NULL,
  `id_prontuario_veterinario` INT NULL,
  `id_prontuario_pet` INT NULL,
  `observacao` VARCHAR(45) NULL,
  `realizado` TINYINT(1) NULL,
  PRIMARY KEY (`idprontuario`),
  CONSTRAINT `fk_pet`
    FOREIGN KEY (`id_prontuario_pet`)
    REFERENCES `veterinaria`.`pet` (`idpet`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_veterinario`
    FOREIGN KEY (`id_prontuario_veterinario`)
    REFERENCES `veterinaria`.`veterinario` (`idveterinario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_pet_idx` ON `veterinaria`.`prontuario` (`id_prontuario_pet` ASC);

CREATE INDEX `fk_veterinario_idx` ON `veterinaria`.`prontuario` (`id_prontuario_veterinario` ASC);


-- -----------------------------------------------------
-- Table `veterinaria`.`consulta_exame`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `veterinaria`.`consulta_exame` ;

CREATE TABLE IF NOT EXISTS `veterinaria`.`consulta_exame` (
  `idconsulta_exame` INT NOT NULL auto_increment,
  `id_consulta_prontuario` INT NOT NULL,
  `id_consulta_exame` INT NULL,
  PRIMARY KEY (`idconsulta_exame`),
  CONSTRAINT `fk_protuario`
    FOREIGN KEY (`id_consulta_prontuario`)
    REFERENCES `veterinaria`.`prontuario` (`idprontuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_exame`
    FOREIGN KEY (`id_consulta_exame`)
    REFERENCES `veterinaria`.`exame` (`idexame`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_exame_consulta_idx` ON `veterinaria`.`consulta_exame` (`id_consulta_exame` ASC);

CREATE INDEX `fk_protuario_idx` ON `veterinaria`.`consulta_exame` (`id_consulta_prontuario` ASC);


-- -----------------------------------------------------
-- Table `veterinaria`.`resultado_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `veterinaria`.`resultado_item` ;

CREATE TABLE IF NOT EXISTS `veterinaria`.`resultado_item` (
  `idresultado_item` INT NOT NULL auto_increment,
  `id_resultado_item` INT NOT NULL,
  PRIMARY KEY (`idresultado_item`),
  CONSTRAINT `fk_item`
    FOREIGN KEY (`id_resultado_item`)
    REFERENCES `veterinaria`.`item` (`iditem`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_item_idx` ON `veterinaria`.`resultado_item` (`id_resultado_item` ASC);


-- -----------------------------------------------------
-- Table `veterinaria`.`Funcionario`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `veterinaria`.`funcionario` ;

CREATE TABLE IF NOT EXISTS `veterinaria`.`funcionario` (
  `idfuncionario` INT NOT NULL auto_increment,
  `funcao` INT NULL,
  `id_funcionario_usuario` INT NULL,
  PRIMARY KEY (`idfuncionario`),
  CONSTRAINT `fk_funcionario_usuario`
    FOREIGN KEY (`id_funcionario_usuario`)
    REFERENCES `veterinaria`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_funcionario_usuario_idx` ON `veterinaria`.`funcionario` (`id_funcionario_usuario` ASC);


-- -----------------------------------------------------
-- Table `veterinaria`.`tipo_acesso`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `veterinaria`.`tipo_acesso` ;

CREATE TABLE IF NOT EXISTS `veterinaria`.`tipo_acesso` (
  `idtipo_acesso` INT NOT NULL auto_increment,
  `rotina` VARCHAR(45) NULL,
  `id_tipo_grupo_acesso` INT NULL,
  PRIMARY KEY (`idtipo_acesso`),
  CONSTRAINT `fk_tipo_grupo_acesso`
    FOREIGN KEY (`id_tipo_grupo_acesso`)
    REFERENCES `veterinaria`.`grupo_acesso` (`idgrupo_acesso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_tipo_grupo_acesso_idx` ON `veterinaria`.`tipo_acesso` (`id_tipo_grupo_acesso` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `veterinaria`.`grupo_acesso` (`idgrupo_acesso`, `descricao`) VALUES ('1', 'Todo');
INSERT INTO `veterinaria`.`grupo_acesso` (`idgrupo_acesso`, `descricao`) VALUES ('2', 'Parcial');

