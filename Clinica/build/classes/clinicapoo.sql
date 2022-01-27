-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: clinicapoo
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `agenda`
--

DROP TABLE IF EXISTS `agenda`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `agenda` (
  `idAgenda` int NOT NULL,
  `codFuncionario` int DEFAULT NULL,
  `Data` date NOT NULL,
  `Hora` time NOT NULL,
  `Tipo_Registo` varchar(70) NOT NULL,
  PRIMARY KEY (`idAgenda`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agenda`
--

LOCK TABLES `agenda` WRITE;
/*!40000 ALTER TABLE `agenda` DISABLE KEYS */;
INSERT INTO `agenda` VALUES (12,202002,'2022-01-20','15:30:00','Consulta');
/*!40000 ALTER TABLE `agenda` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alta`
--

DROP TABLE IF EXISTS `alta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alta` (
  `idAlta` int NOT NULL AUTO_INCREMENT,
  `dataAlta` date NOT NULL,
  `codPaciente` int DEFAULT NULL,
  `codFuncionario` int DEFAULT NULL,
  PRIMARY KEY (`idAlta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alta`
--

LOCK TABLES `alta` WRITE;
/*!40000 ALTER TABLE `alta` DISABLE KEYS */;
INSERT INTO `alta` VALUES (1,'2022-01-03',555551,0),(2,'2021-01-01',555552,0),(3,'2021-01-01',555552,0),(4,'2021-01-01',555552,112);
/*!40000 ALTER TABLE `alta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cirurgia`
--

DROP TABLE IF EXISTS `cirurgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cirurgia` (
  `numeroCirurgia` int NOT NULL,
  `codPaciente` int NOT NULL,
  `nomePac` varchar(30) DEFAULT NULL,
  `nomeMed` varchar(30) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`numeroCirurgia`),
  KEY `codPaciente` (`codPaciente`),
  CONSTRAINT `cirurgia_ibfk_1` FOREIGN KEY (`codPaciente`) REFERENCES `paciente` (`codPaciente`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cirurgia`
--

LOCK TABLES `cirurgia` WRITE;
/*!40000 ALTER TABLE `cirurgia` DISABLE KEYS */;
INSERT INTO `cirurgia` VALUES (666662,808,'Ludimila','Kelvin','2020-01-28','01:30:00','Activa');
/*!40000 ALTER TABLE `cirurgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consulta`
--

DROP TABLE IF EXISTS `consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consulta` (
  `numeroConsulta` int NOT NULL,
  `codPaciente` int NOT NULL,
  `nomePac` varchar(30) NOT NULL,
  `nomeMed` varchar(30) NOT NULL,
  `data` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`numeroConsulta`),
  KEY `codPaciente` (`codPaciente`),
  CONSTRAINT `consulta_ibfk_1` FOREIGN KEY (`codPaciente`) REFERENCES `paciente` (`codPaciente`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta`
--

LOCK TABLES `consulta` WRITE;
/*!40000 ALTER TABLE `consulta` DISABLE KEYS */;
INSERT INTO `consulta` VALUES (222,808,'Ludimila','Kelvin','2020-01-31','15:30:00','Activa');
/*!40000 ALTER TABLE `consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `consulta_funcionario`
--

DROP TABLE IF EXISTS `consulta_funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `consulta_funcionario` (
  `numeroConsulta` int NOT NULL,
  `codFuncionario` int NOT NULL,
  `Data` date NOT NULL,
  `Hora` time NOT NULL,
  PRIMARY KEY (`numeroConsulta`,`codFuncionario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `consulta_funcionario`
--

LOCK TABLES `consulta_funcionario` WRITE;
/*!40000 ALTER TABLE `consulta_funcionario` DISABLE KEYS */;
INSERT INTO `consulta_funcionario` VALUES (600001,202001,'0000-00-00','00:00:00'),(600002,202001,'0000-00-00','00:00:00'),(600003,202005,'0000-00-00','00:00:00'),(600004,202001,'0000-00-00','00:00:00'),(600005,202001,'0000-00-00','00:00:00'),(600006,202005,'0000-00-00','00:00:00');
/*!40000 ALTER TABLE `consulta_funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doenca`
--

DROP TABLE IF EXISTS `doenca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doenca` (
  `codDoenca` int NOT NULL,
  `nome` varchar(30) NOT NULL,
  `contagio` varchar(10) NOT NULL,
  PRIMARY KEY (`codDoenca`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doenca`
--

LOCK TABLES `doenca` WRITE;
/*!40000 ALTER TABLE `doenca` DISABLE KEYS */;
INSERT INTO `doenca` VALUES (333331,'Catarata','N Contagio'),(333332,'AVC','N Contagio'),(333333,'Diabetes','N Contagio'),(333334,'Hipertensao','N Contagio'),(333335,'Glaucoma','Contagiosa'),(333336,'Cancro','N Contagio'),(333337,'Acidente','N Contagio');
/*!40000 ALTER TABLE `doenca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enfermeiro`
--

DROP TABLE IF EXISTS `enfermeiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enfermeiro` (
  `codFuncionario` int DEFAULT NULL,
  `categoria` varchar(120) DEFAULT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enfermeiro`
--

LOCK TABLES `enfermeiro` WRITE;
/*!40000 ALTER TABLE `enfermeiro` DISABLE KEYS */;
INSERT INTO `enfermeiro` VALUES (202004,'Saude',1),(202006,'Tecnico',2),(202004,'Saude',3),(202006,'Tecnico',4),(157,'Tecnico de enfermagem',12),(189,'Parteira',14),(207,'Parteira',15),(68,'Tecnico de enfermagem',16),(572,'Parteira',17);
/*!40000 ALTER TABLE `enfermeiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enfermeiro_cirurgia`
--

DROP TABLE IF EXISTS `enfermeiro_cirurgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enfermeiro_cirurgia` (
  `codFuncionario` int NOT NULL,
  `numeroCirurgia` int NOT NULL,
  PRIMARY KEY (`codFuncionario`,`numeroCirurgia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enfermeiro_cirurgia`
--

LOCK TABLES `enfermeiro_cirurgia` WRITE;
/*!40000 ALTER TABLE `enfermeiro_cirurgia` DISABLE KEYS */;
INSERT INTO `enfermeiro_cirurgia` VALUES (202004,666662),(202005,666661);
/*!40000 ALTER TABLE `enfermeiro_cirurgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionario` (
  `codFuncionario` int NOT NULL,
  `nome` varchar(60) NOT NULL,
  `sexo` varchar(50) DEFAULT NULL,
  `contacto` varchar(10) NOT NULL,
  `Morada` varchar(30) NOT NULL,
  `Nacionalidade` varchar(30) NOT NULL,
  `Departamento` varchar(30) NOT NULL,
  PRIMARY KEY (`codFuncionario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (27,'Gloria Uamusse','Femenino','11111111','Fomento','Mocambicana','Pediatria'),(68,'Ana Maria','Femenino','1236554789','Matola C','Mocambicana','Pediatria'),(112,'Ana Maria da Graca','Femenino','847689409','Fomento','Cubana','xxxxxxx'),(157,'Marcos Antonio','Masculino','33333333','Fomento','Gana','Estomatologia'),(183,'Camila Lucas','Femenino','87251878','Matola','Russa','cardiologia'),(189,'Mateus','Masculino','4444444','Fomento','Moz','CArio'),(207,'Lucas Amancio','Masculino','8457654','Matola','Russa','Cardiologia'),(212,'','Femenino','','','',''),(572,'Vania Amancio','Femenino','84759415','Ndlavela','Gana','Ortopedia'),(626,'Miguel','Masculino','2222222','Maputo','Russa','Ortopedia'),(926,'Graca Maria','Femenino','847689409','MAtola','Russa','Cardiologia'),(202001,'Amarilda','F','1000000000','','',''),(202002,'Celestino','M','100000001','','',''),(202003,'Kelvin','M','100000002','','',''),(202004,'Ludi','F','100000003','','',''),(202005,'Agostinho','M','100000004','','',''),(202006,'Faira','F','100000005','','','');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `internamento`
--

DROP TABLE IF EXISTS `internamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `internamento` (
  `dataInternamento` date NOT NULL,
  `codPaciente` int DEFAULT NULL,
  `idInternamento` int NOT NULL AUTO_INCREMENT,
  `codFuncionario` int DEFAULT NULL,
  `doenca` varchar(50) NOT NULL,
  PRIMARY KEY (`idInternamento`),
  KEY `codPaciente` (`codPaciente`),
  CONSTRAINT `internamento_ibfk_1` FOREIGN KEY (`codPaciente`) REFERENCES `paciente` (`codPaciente`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `internamento`
--

LOCK TABLES `internamento` WRITE;
/*!40000 ALTER TABLE `internamento` DISABLE KEYS */;
INSERT INTO `internamento` VALUES ('2022-01-02',555552,3,0,'Malaria'),('2021-01-04',555551,4,0,'Tuberculose'),('2022-02-02',555551,5,0,'Malaria'),('2021-01-02',555551,6,0,'Malaria'),('2021-01-01',555552,7,0,'CoronaVirus'),('2021-01-03',555552,8,0,'TB'),('2022-01-07',808,9,0,'Malaria'),('2022-01-04',555554,10,0,'SIDA'),('2021-01-01',763,11,189,'AAAAA');
/*!40000 ALTER TABLE `internamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medico` (
  `codFuncionario` int DEFAULT NULL,
  `Especializacao` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
INSERT INTO `medico` VALUES (202002,'Cardiologista'),(202003,'Oftalmologista'),(202002,'Cardiologista'),(202003,'Oftalmologista'),(112,'xxxxxxx');
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico_cirurgia`
--

DROP TABLE IF EXISTS `medico_cirurgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medico_cirurgia` (
  `numeroCirurgia` int NOT NULL,
  `codFuncionario` int NOT NULL,
  PRIMARY KEY (`codFuncionario`,`numeroCirurgia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico_cirurgia`
--

LOCK TABLES `medico_cirurgia` WRITE;
/*!40000 ALTER TABLE `medico_cirurgia` DISABLE KEYS */;
INSERT INTO `medico_cirurgia` VALUES (666662,202002),(666661,202003);
/*!40000 ALTER TABLE `medico_cirurgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente`
--

DROP TABLE IF EXISTS `paciente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paciente` (
  `codPaciente` int NOT NULL,
  `nome` varchar(30) NOT NULL,
  `genero` varchar(30) DEFAULT NULL,
  `morada` varchar(30) NOT NULL,
  `Idade` int NOT NULL,
  `BI` varchar(13) NOT NULL,
  `Estado_Civil` varchar(50) NOT NULL,
  `Nacionalidade` varchar(50) NOT NULL,
  `Telefone` varchar(40) DEFAULT NULL,
  `Tel_Alternativo` varchar(40) DEFAULT NULL,
  `Apelido` varchar(40) NOT NULL,
  PRIMARY KEY (`codPaciente`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente`
--

LOCK TABLES `paciente` WRITE;
/*!40000 ALTER TABLE `paciente` DISABLE KEYS */;
INSERT INTO `paciente` VALUES (123,'Lina ','Femenino','Malhazine',7,'314848448484','Casado(a)','MOz','5555555','55555','Chihepe'),(210,'aaaa','Masculino','aaa',4,'aaa','Solteiro(a)','aaa','aaa','aaaa','aaaa'),(263,'aaaaa','Masculino','aaaaaa',15,'aaaaa','Solteiro(a)','aaaaa','11111','22222','aaaaa'),(418,'bbb','Masculino','bfff',5,'111111','Solteiro(a)','cccc','Masculino','Masculino','aaaa'),(755,'aaa','Masculino','aaa',5,'a','Solteiro(a)','aaa','a','a','aaaaa'),(763,'Americo','Masculino','Matola',8,'123654','Solteiro(a)','Russa','789654','45698','Julio'),(808,'Ludimila','Femenino','Mavotas',5,'789654123','Casado(a)','Russa','1265','79895','Mucevel'),(555551,'Antonio','M','Magude',0,'','','',NULL,NULL,''),(555552,'Jonas','M','Xinavane',0,'','','',NULL,NULL,''),(555553,'Marta','F','Motaze',0,'','','',NULL,NULL,''),(555554,'Maria','F','Duku',0,'','','',NULL,NULL,''),(555555,'Esperanca','F','Santo Antonio',0,'','','',NULL,NULL,''),(555556,'Cristina','F','Makupe',0,'','','',NULL,NULL,''),(555557,'Lucas','M','Mahotas',0,'','','',NULL,NULL,''),(555558,'Larissa','F','Aeroporto',0,'','','',NULL,NULL,'');
/*!40000 ALTER TABLE `paciente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente_cirurgia`
--

DROP TABLE IF EXISTS `paciente_cirurgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paciente_cirurgia` (
  `codPaciente` int NOT NULL,
  `numeroCirurgia` int NOT NULL,
  PRIMARY KEY (`codPaciente`,`numeroCirurgia`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente_cirurgia`
--

LOCK TABLES `paciente_cirurgia` WRITE;
/*!40000 ALTER TABLE `paciente_cirurgia` DISABLE KEYS */;
INSERT INTO `paciente_cirurgia` VALUES (555551,666662),(555553,666661);
/*!40000 ALTER TABLE `paciente_cirurgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente_consulta`
--

DROP TABLE IF EXISTS `paciente_consulta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paciente_consulta` (
  `codPaciente` int NOT NULL,
  `numeroConsulta` int NOT NULL,
  `data` date NOT NULL,
  `horario` time DEFAULT NULL,
  PRIMARY KEY (`codPaciente`,`numeroConsulta`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente_consulta`
--

LOCK TABLES `paciente_consulta` WRITE;
/*!40000 ALTER TABLE `paciente_consulta` DISABLE KEYS */;
INSERT INTO `paciente_consulta` VALUES (555551,600003,'2021-07-10','06:45:00'),(555552,600001,'2021-06-30','12:23:25'),(555553,600002,'2021-05-15','04:59:52'),(555554,600004,'2021-03-10','11:23:09'),(555555,600005,'2021-01-11','13:56:23'),(555556,600006,'2020-12-31','23:02:05');
/*!40000 ALTER TABLE `paciente_consulta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente_doenca`
--

DROP TABLE IF EXISTS `paciente_doenca`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paciente_doenca` (
  `codPaciente` int NOT NULL,
  `codDoenca` int NOT NULL,
  PRIMARY KEY (`codPaciente`,`codDoenca`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente_doenca`
--

LOCK TABLES `paciente_doenca` WRITE;
/*!40000 ALTER TABLE `paciente_doenca` DISABLE KEYS */;
INSERT INTO `paciente_doenca` VALUES (555552,333332),(555554,333333),(555556,333336);
/*!40000 ALTER TABLE `paciente_doenca` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente_enfermeiro`
--

DROP TABLE IF EXISTS `paciente_enfermeiro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paciente_enfermeiro` (
  `codPaciente` int NOT NULL,
  `codFuncionario` int NOT NULL,
  `Turno` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`codPaciente`,`codFuncionario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente_enfermeiro`
--

LOCK TABLES `paciente_enfermeiro` WRITE;
/*!40000 ALTER TABLE `paciente_enfermeiro` DISABLE KEYS */;
INSERT INTO `paciente_enfermeiro` VALUES (555551,202004,'Manha'),(555552,202005,NULL),(555553,202005,NULL),(555554,202005,NULL),(555555,202004,NULL),(555556,202004,NULL);
/*!40000 ALTER TABLE `paciente_enfermeiro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paciente_medico`
--

DROP TABLE IF EXISTS `paciente_medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paciente_medico` (
  `codPaciente` int NOT NULL,
  `codFuncionario` int NOT NULL,
  `Turno` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`codPaciente`,`codFuncionario`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paciente_medico`
--

LOCK TABLES `paciente_medico` WRITE;
/*!40000 ALTER TABLE `paciente_medico` DISABLE KEYS */;
INSERT INTO `paciente_medico` VALUES (555551,202002,NULL),(555552,202002,NULL),(555553,202003,NULL),(555554,202003,NULL),(555555,202003,NULL),(555556,202003,NULL);
/*!40000 ALTER TABLE `paciente_medico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secretario`
--

DROP TABLE IF EXISTS `secretario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `secretario` (
  `codFuncionario` int DEFAULT NULL,
  `nome` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `cargo` varchar(100) DEFAULT NULL,
  `numero_Balcao` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secretario`
--

LOCK TABLES `secretario` WRITE;
/*!40000 ALTER TABLE `secretario` DISABLE KEYS */;
INSERT INTO `secretario` VALUES (202001,'Amarilda','amarildachihepe@gmail.com','Secretario',1);
/*!40000 ALTER TABLE `secretario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-27  1:39:59
