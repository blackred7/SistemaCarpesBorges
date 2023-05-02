CREATE DATABASE  IF NOT EXISTS `maycon_borges` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `maycon_borges`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: maycon_borges
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adm`
--

DROP TABLE IF EXISTS `adm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adm` (
  `idadm` int unsigned NOT NULL,
  `nome` varchar(45) NOT NULL,
  `email` varchar(50) NOT NULL,
  `sexo` char(1) DEFAULT NULL,
  `numero_tel` varchar(15) DEFAULT NULL,
  `fk_usuario` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`idadm`),
  UNIQUE KEY `idadm_UNIQUE` (`idadm`),
  KEY `fkusuario` (`fk_usuario`),
  CONSTRAINT `fkusuario` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adm`
--

LOCK TABLES `adm` WRITE;
/*!40000 ALTER TABLE `adm` DISABLE KEYS */;
/*!40000 ALTER TABLE `adm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int unsigned NOT NULL AUTO_INCREMENT,
  `historico_compra` varchar(70) NOT NULL,
  `email` varchar(50) NOT NULL,
  `sexo` char(1) DEFAULT NULL,
  `data_cadastro` datetime NOT NULL,
  `end` varchar(50) NOT NULL,
  `rg` varchar(15) NOT NULL,
  `porte_pessoal` varchar(45) DEFAULT NULL,
  `foto` varchar(345) DEFAULT NULL,
  `descricao` varchar(245) DEFAULT NULL,
  `premiun` varchar(1) CHARACTER SET utf8mb3 COLLATE utf8mb3_bin NOT NULL,
  `indentificacao` int NOT NULL,
  `clientecol` varchar(45) DEFAULT NULL,
  `criminal` varchar(45) NOT NULL,
  `preferencias` varchar(45) DEFAULT NULL,
  `fk_idusuario` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `id_cliente_UNIQUE` (`id_cliente`),
  KEY `fk_idusuario` (`fk_idusuario`),
  CONSTRAINT `fk_idusuario` FOREIGN KEY (`fk_idusuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras` (
  `id_compra` int unsigned NOT NULL AUTO_INCREMENT,
  `fk_funcionario` int unsigned NOT NULL,
  `fk_fornecedor` int NOT NULL,
  PRIMARY KEY (`id_compra`),
  UNIQUE KEY `id_compra_UNIQUE` (`id_compra`),
  KEY `fk_fornecedor_idx` (`fk_fornecedor`),
  KEY `fk_funcionario_idx` (`fk_funcionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornecedor` (
  `id_fornecedor` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `email` varchar(50) NOT NULL,
  `cpf_cnpj` int NOT NULL,
  `end` varchar(45) NOT NULL,
  PRIMARY KEY (`id_fornecedor`),
  UNIQUE KEY `id_fornecedor_UNIQUE` (`id_fornecedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `id_funcionario` int unsigned NOT NULL AUTO_INCREMENT,
  `sexo` char(1) DEFAULT NULL,
  `email` varchar(60) NOT NULL,
  `numero_tel` varchar(15) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `fk_usuario` int NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cpf` int NOT NULL,
  PRIMARY KEY (`id_funcionario`),
  UNIQUE KEY `id_funcionario_UNIQUE` (`id_funcionario`),
  KEY `fk_usuario` (`fk_usuario`),
  CONSTRAINT `fk_usuario` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario` (`idusuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `id_produto` int unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `preco` decimal(8,2) unsigned NOT NULL,
  `quandidade` smallint unsigned NOT NULL,
  `foto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_produto`),
  UNIQUE KEY `id_produto_UNIQUE` (`id_produto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto_compra`
--

DROP TABLE IF EXISTS `produto_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto_compra` (
  `fk_produto` int unsigned NOT NULL,
  `fk_compra` int unsigned NOT NULL,
  `quantidade` tinyint unsigned NOT NULL,
  `data_hora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valor_unitario` decimal(8,2) NOT NULL,
  `valor_total` decimal(12,2) NOT NULL,
  KEY `fk_compra` (`fk_compra`),
  KEY `fk_produto` (`fk_produto`),
  CONSTRAINT `fk_compra` FOREIGN KEY (`fk_compra`) REFERENCES `compras` (`id_compra`),
  CONSTRAINT `fk_produto` FOREIGN KEY (`fk_produto`) REFERENCES `produto` (`id_produto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto_compra`
--

LOCK TABLES `produto_compra` WRITE;
/*!40000 ALTER TABLE `produto_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto_vendas`
--

DROP TABLE IF EXISTS `produto_vendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto_vendas` (
  `fk_produto` int unsigned NOT NULL,
  `fk_vendas` int unsigned NOT NULL,
  `quantidade` tinyint unsigned NOT NULL,
  `valor_unitario` decimal(8,2) NOT NULL,
  `data_hora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valor_total` decimal(12,2) NOT NULL,
  PRIMARY KEY (`fk_produto`,`fk_vendas`),
  UNIQUE KEY `fk_produto_UNIQUE` (`fk_produto`),
  KEY `id_vendas` (`fk_vendas`),
  CONSTRAINT `id_produto` FOREIGN KEY (`fk_produto`) REFERENCES `produto` (`id_produto`),
  CONSTRAINT `id_vendas` FOREIGN KEY (`fk_vendas`) REFERENCES `vendas` (`id_vendas`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto_vendas`
--

LOCK TABLES `produto_vendas` WRITE;
/*!40000 ALTER TABLE `produto_vendas` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto_vendas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idusuario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `apelido` varchar(45) NOT NULL,
  `cpf` int NOT NULL,
  `nivel` int NOT NULL,
  `ativo` varchar(1) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `data_nasc` date NOT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE KEY `idusuario_UNIQUE` (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendas`
--

DROP TABLE IF EXISTS `vendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendas` (
  `id_vendas` int unsigned NOT NULL AUTO_INCREMENT,
  `data_hora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `fk_cliente` int unsigned NOT NULL,
  `fk_funcionario` int unsigned NOT NULL,
  PRIMARY KEY (`id_vendas`),
  UNIQUE KEY `id_vendas_UNIQUE` (`id_vendas`),
  KEY `fk_cliente` (`fk_cliente`),
  KEY `fk_funcionario` (`fk_funcionario`),
  CONSTRAINT `fk_cliente` FOREIGN KEY (`fk_cliente`) REFERENCES `cliente` (`id_cliente`),
  CONSTRAINT `fk_funcionario` FOREIGN KEY (`fk_funcionario`) REFERENCES `funcionario` (`id_funcionario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendas`
--

LOCK TABLES `vendas` WRITE;
/*!40000 ALTER TABLE `vendas` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendas` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-05-01 14:59:32
