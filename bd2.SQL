-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 10.7.0.51    Database: db_maycon_borges
-- ------------------------------------------------------
-- Server version	5.7.42

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
-- Table structure for table `Produto_vendas`
--

DROP TABLE IF EXISTS `Produto_vendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Produto_vendas` (
  `fk_produto` int(10) unsigned NOT NULL,
  `fk_vendas` int(10) unsigned NOT NULL,
  `quantidade` tinyint(3) unsigned NOT NULL,
  `valor_unitario` decimal(8,2) NOT NULL,
  `data_hora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valor_total` decimal(12,2) NOT NULL,
  PRIMARY KEY (`fk_produto`,`fk_vendas`),
  UNIQUE KEY `fk_produto_UNIQUE` (`fk_produto`),
  UNIQUE KEY `fk_vendas_UNIQUE` (`fk_vendas`),
  CONSTRAINT `id_produto` FOREIGN KEY (`fk_produto`) REFERENCES `produto` (`id_produto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `id_vendas` FOREIGN KEY (`fk_vendas`) REFERENCES `vendas` (`id_vendas`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Produto_vendas`
--

LOCK TABLES `Produto_vendas` WRITE;
/*!40000 ALTER TABLE `Produto_vendas` DISABLE KEYS */;
/*!40000 ALTER TABLE `Produto_vendas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adm`
--

DROP TABLE IF EXISTS `adm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adm` (
  `idadm` int(10) unsigned NOT NULL,
  `nome` varchar(45) NOT NULL,
  `email` varchar(50) NOT NULL,
  `sexo` char(1) DEFAULT NULL,
  `numero_tel` varchar(15) DEFAULT NULL,
  `fk_usuario` int(11) NOT NULL,
  PRIMARY KEY (`idadm`),
  UNIQUE KEY `idadm_UNIQUE` (`idadm`),
  KEY `fkusuario_idx` (`fk_usuario`),
  CONSTRAINT `fkusuario` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adm`
--

LOCK TABLES `adm` WRITE;
/*!40000 ALTER TABLE `adm` DISABLE KEYS */;
INSERT INTO `adm` VALUES (1,'Maycon','maycon@.com','M','1213',1),(2,'Daniel','daniel@.com','M','45213',2),(3,'prof marcos','profmarcos@gmail.com','M','245245',1);
/*!40000 ALTER TABLE `adm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `id_cliente` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `historico_compra` varchar(70) NOT NULL,
  `email` varchar(50) NOT NULL,
  `sexo` char(1) DEFAULT NULL,
  `data_cadastro` datetime NOT NULL,
  `end` varchar(50) NOT NULL,
  `rg` varchar(15) NOT NULL,
  `porte_pessoal` varchar(45) DEFAULT NULL,
  `foto` varchar(345) DEFAULT NULL,
  `descricao` varchar(245) DEFAULT NULL,
  `premiun` char(1) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `indentificacao` int(11) NOT NULL,
  `criminal` char(1) NOT NULL,
  `preferencias` varchar(45) DEFAULT NULL,
  `fk_idusuario` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE KEY `id_cliente_UNIQUE` (`id_cliente`),
  KEY `fk_idusuario_idx` (`fk_idusuario`),
  CONSTRAINT `fk_idusuario` FOREIGN KEY (`fk_idusuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (11,'Tanque t-34','geovane@gmail.com','H','3923-02-01 00:00:00','aral moreira','ms-5765','não',NULL,'hetero afeminado','S',0,'N','veiculos paramilitares',1,'geovane');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compras`
--

DROP TABLE IF EXISTS `compras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compras` (
  `id_compra` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fk_funcionario` int(11) unsigned NOT NULL,
  `fk_fornecedor` int(11) NOT NULL,
  PRIMARY KEY (`id_compra`),
  UNIQUE KEY `id_compra_UNIQUE` (`id_compra`),
  KEY `fk_fornecedor_idx` (`fk_fornecedor`),
  KEY `fk_funcionario_idx` (`fk_funcionario`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compras`
--

LOCK TABLES `compras` WRITE;
/*!40000 ALTER TABLE `compras` DISABLE KEYS */;
INSERT INTO `compras` VALUES (2,1,1),(3,0,1);
/*!40000 ALTER TABLE `compras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fornecedor`
--

DROP TABLE IF EXISTS `fornecedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `fornecedor` (
  `id_fornecedor` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `email` varchar(50) NOT NULL,
  `cpf_cnpj` varchar(15) NOT NULL,
  `end` varchar(45) NOT NULL,
  PRIMARY KEY (`id_fornecedor`),
  UNIQUE KEY `id_fornecedor_UNIQUE` (`id_fornecedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedor`
--

LOCK TABLES `fornecedor` WRITE;
/*!40000 ALTER TABLE `fornecedor` DISABLE KEYS */;
INSERT INTO `fornecedor` VALUES (1,'mercante','weucomehehehe@gmail.com','121.222.222-22','ilha de los iluminados');
/*!40000 ALTER TABLE `fornecedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `id_funcionario` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `sexo` char(1) DEFAULT NULL,
  `email` varchar(60) NOT NULL,
  `numero_tel` varchar(15) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `fk_usuario` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  PRIMARY KEY (`id_funcionario`),
  UNIQUE KEY `id_funcionario_UNIQUE` (`id_funcionario`),
  KEY `fk_usuario_idx` (`fk_usuario`),
  CONSTRAINT `fk_usuario` FOREIGN KEY (`fk_usuario`) REFERENCES `usuario` (`idusuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'M','larry32@gmail.com','154145643',NULL,1,'larry','447.624.237-12');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto`
--

DROP TABLE IF EXISTS `produto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto` (
  `id_produto` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `descricao` varchar(255) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `preco` varchar(11) NOT NULL,
  `quandidade` smallint(5) unsigned NOT NULL,
  `foto` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_produto`),
  UNIQUE KEY `id_produto_UNIQUE` (`id_produto`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto`
--

LOCK TABLES `produto` WRITE;
/*!40000 ALTER TABLE `produto` DISABLE KEYS */;
INSERT INTO `produto` VALUES (1,'cleymore','um explosivo acionado por contato perfeito para emboscadas','explovivo','45.00',76,'//foto.org'),(2,'aguia do deserto','uma pistola padrão','semi_automatica','345.00',146,'//foto.org'),(3,'RPD','uma metralhadora leve com muita munição e auta cadencia','automatica','1625.00',753,'//foto.org'),(4,'SVD Dragunov','um fuzil semiautomático para atiradores de elite, é equipável com uma baioneta AK','semi_automatica','1425.00',453,'//foto.org'),(5,'Armsel Striker','ma escopeta calibre 12 com um tambor giratório projetada para controle de tumultos e combate.','semi_automatica','1425.00',343,'//foto.org'),(6,'t-14 armata','Tanque de guerra mais avançado do mundo. \nUm dos diferenciais do T-14 Armata\n é levar a tripulação dentro de uma espécie \nde \"cápsula\" blindada no interior do tanque. \nAlém disso, ele também tem uma torre \ntotalmente automatizada e não tripulada','veiculo blindado','20318,99',11,NULL);
/*!40000 ALTER TABLE `produto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produto_compra`
--

DROP TABLE IF EXISTS `produto_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produto_compra` (
  `fk_produto` int(10) unsigned NOT NULL,
  `fk_compra` int(10) unsigned NOT NULL,
  `quantidade` tinyint(3) unsigned NOT NULL,
  `data_hora` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `valor_unitario` decimal(8,2) NOT NULL,
  `valor_total` decimal(12,2) NOT NULL,
  KEY `fk_produto_idx` (`fk_produto`),
  KEY `fk_compra_idx` (`fk_compra`),
  CONSTRAINT `fk_compra` FOREIGN KEY (`fk_compra`) REFERENCES `compras` (`id_compra`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_produto` FOREIGN KEY (`fk_produto`) REFERENCES `produto` (`id_produto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produto_compra`
--

LOCK TABLES `produto_compra` WRITE;
/*!40000 ALTER TABLE `produto_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `produto_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `apelido` varchar(45) NOT NULL,
  `cpf` varchar(15) NOT NULL,
  `nivel` int(11) NOT NULL,
  `ativo` varchar(1) NOT NULL,
  `senha` varchar(20) NOT NULL,
  `data_nasc` date NOT NULL,
  PRIMARY KEY (`idusuario`),
  UNIQUE KEY `idusuario_UNIQUE` (`idusuario`)
) ENGINE=InnoDB AUTO_INCREMENT=223 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Maycon Rendrew','borges','111.111.111-11',0,'S','senha123','3923-02-01'),(2,'Daniel Bogarin','carpes','1242354067',1,'S','senha123','3923-02-01'),(3,'Walter White','Heisenberg','442324067',2,'S','senha123','3923-02-01'),(4,'Simon Riley','Ghost','447624237',2,'S','senha123','3923-02-01'),(5,'Laurence Needlemeyer','Larry','447234637',2,'S','senha123','3923-02-01'),(6,'dante','mata capeta','6666666',2,'S','lady','3923-02-01'),(222,'123','123','111.111.111-11',2,'S','123','3923-02-01');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendas`
--

DROP TABLE IF EXISTS `vendas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendas` (
  `id_vendas` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `fk_cliente` int(11) unsigned NOT NULL,
  `fk_funcionario` int(11) unsigned NOT NULL,
  PRIMARY KEY (`id_vendas`),
  UNIQUE KEY `id_vendas_UNIQUE` (`id_vendas`),
  KEY `fk_funcionario_idx` (`fk_funcionario`),
  KEY `fk_cliente_idx` (`fk_cliente`),
  CONSTRAINT `fk_cliente` FOREIGN KEY (`fk_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_funcionario` FOREIGN KEY (`fk_funcionario`) REFERENCES `funcionario` (`id_funcionario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
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

-- Dump completed on 2023-05-29 12:58:14
