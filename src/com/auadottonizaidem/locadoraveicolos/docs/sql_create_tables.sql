SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `locadoraveiculo` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

CREATE TABLE IF NOT EXISTS `locadoraveiculo`.`funcionario` (
  `id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '	',
  `nome_completo` VARCHAR(200) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `sexo` ENUM('m', 'f') NOT NULL,
  `data_nascimento` BIGINT(20) NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `senha` TEXT NOT NULL,
  `data_cadastro` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `locadoraveiculo`.`cliente` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome_completo` VARCHAR(200) NOT NULL,
  `cpf` VARCHAR(14) NOT NULL,
  `sexo` ENUM('m','f') NOT NULL,
  `data_nascimento` BIGINT(20) NOT NULL,
  `data_cadastro` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `locadoraveiculo`.`veiculo` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(100) NOT NULL,
  `marca` VARCHAR(200) NOT NULL,
  `cilindrada` VARCHAR(3) NOT NULL,
  `placa` VARCHAR(8) NOT NULL,
  `cor` VARCHAR(45) NOT NULL,
  `data_fabricacao` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `locadoraveiculo`.`locacao` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `cliente_locador` INT(11) NOT NULL,
  `veiculo_locado` INT(11) NOT NULL,
  `funcionario_responsavel` INT(11) NOT NULL,
  `data_locacao` BIGINT(20) NOT NULL,
  `concluida` TINYINT(1) NULL DEFAULT FALSE,
  PRIMARY KEY (`id`),
  INDEX `fk_locacao_cliente_idx` (`cliente_locador` ASC),
  INDEX `fk_locacao_veiculo1_idx` (`veiculo_locado` ASC),
  INDEX `fk_locacao_funcionario1_idx` (`funcionario_responsavel` ASC),
  CONSTRAINT `fk_locacao_cliente`
    FOREIGN KEY (`cliente_locador`)
    REFERENCES `locadoraveiculo`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_locacao_veiculo1`
    FOREIGN KEY (`veiculo_locado`)
    REFERENCES `locadoraveiculo`.`veiculo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_locacao_funcionario1`
    FOREIGN KEY (`funcionario_responsavel`)
    REFERENCES `locadoraveiculo`.`funcionario` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

