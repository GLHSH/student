/*
MySQL Backup
Database: data
Backup Time: 2021-09-30 20:27:36
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `data`.`user`;
DROP TABLE IF EXISTS `data`.`学生表`;
DROP TABLE IF EXISTS `data`.`教师表`;
DROP TABLE IF EXISTS `data`.`管理员表`;
DROP TABLE IF EXISTS `data`.`课程表`;
DROP TABLE IF EXISTS `data`.`选课表`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `upass` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `type` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `学生表` (
  `学生id` int NOT NULL,
  `学生姓名` varchar(20) NOT NULL,
  `部门` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`学生id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `教师表` (
  `教师id` int NOT NULL,
  `教师姓名` varchar(20) DEFAULT NULL,
  `部门` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`教师id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `管理员表` (
  `管理员id` int NOT NULL,
  `管理员姓名` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`管理员id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `课程表` (
  `课程号` varchar(20) NOT NULL,
  `课程名` varchar(20) NOT NULL,
  `学分` double NOT NULL,
  `教师id` int DEFAULT NULL,
  PRIMARY KEY (`课程号`),
  KEY `2` (`教师id`),
  KEY `课程名` (`课程名`),
  CONSTRAINT `2` FOREIGN KEY (`教师id`) REFERENCES `教师表` (`教师id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
CREATE TABLE `选课表` (
  `学期` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `课程号` varchar(20) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `学生id` int DEFAULT NULL,
  `成绩` int DEFAULT NULL,
  KEY `1` (`学生id`) USING BTREE,
  CONSTRAINT `1` FOREIGN KEY (`学生id`) REFERENCES `学生表` (`学生id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `Z1` CHECK ((`成绩` between 0 and 100))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
BEGIN;
LOCK TABLES `data`.`user` WRITE;
DELETE FROM `data`.`user`;
INSERT INTO `data`.`user` (`id`,`upass`,`type`) VALUES (1, '1111', 1),(2, '2222', 2),(3, '3333', 2),(4, 'aaaa', 2),(5, '5555', 2),(21, 'aaaa', 3),(22, 'qqqq', 3),(23, 'wwww', 3);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `data`.`学生表` WRITE;
DELETE FROM `data`.`学生表`;
INSERT INTO `data`.`学生表` (`学生id`,`学生姓名`,`部门`) VALUES (21, '胡1', '软件工程'),(22, '苏1', '大数据'),(23, '刘1', '计算机');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `data`.`教师表` WRITE;
DELETE FROM `data`.`教师表`;
INSERT INTO `data`.`教师表` (`教师id`,`教师姓名`,`部门`) VALUES (2, '李老师', '软件教研室'),(3, '刘老师', '计算机教研室'),(4, '黄老师', '体育教研部'),(5, '王老师', '数学教研部');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `data`.`管理员表` WRITE;
DELETE FROM `data`.`管理员表`;
INSERT INTO `data`.`管理员表` (`管理员id`,`管理员姓名`) VALUES (1, '张三');
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `data`.`课程表` WRITE;
DELETE FROM `data`.`课程表`;
INSERT INTO `data`.`课程表` (`课程号`,`课程名`,`学分`,`教师id`) VALUES ('a1001', 'JAVA', 3, 2),('a1002', 'C语言', 4, 2),('a1003', 'OS', 2, 3),('a1004', '数据库原理', 3, 3),('b2001', 'C++', 2.5, 2),('b2002', '近代史纲要', 4, 5),('b2003', 'Web前端开发', 3.5, 2),('b2004', '线性代数', 1.5, 5),('c3001', '数据结构', 2.5, 3),('c3002', '计算机科学导论', 2.5, 3),('c3003', '数字电路', 2, 3),('c3004', '高等数学', 3.5, 5),('c3005', '人机交互技术', 2, 2),('c3006', '体育I', 1, 4),('c3007', '高等数学提高班', 3.5, 5);
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `data`.`选课表` WRITE;
DELETE FROM `data`.`选课表`;
INSERT INTO `data`.`选课表` (`学期`,`课程号`,`学生id`,`成绩`) VALUES ('202002', 'b2001', 21, 58),('202002', 'b2002', 22, 77),('202002', 'b2003', 23, 82),('202002', 'b2004', 21, 99),('202001', 'c3001', 21, 71),('202001', 'c3002', 23, 84),('202001', 'c3003', 22, 70),('202001', 'c3004', 21, 68),('202001', 'c3005', 23, 74),('202001', 'c3006', 22, 60),('202001', 'c3007', 21, 55),('202001', 'c3001', 22, 77),('202002', 'b2001', 22, 60),('202002', 'b2001', 23, 65),('202001', 'c3006', 21, 66),('202001', 'c3006', 22, 70),('202101', 'a1002', NULL, NULL),('202101', 'a1001', NULL, NULL),('202101', 'a1003', NULL, NULL),('202101', 'a1004', NULL, NULL),('202101', 'a1001', 21, 50),('202101', 'a1002', 21, 100),('202101', 'a1003', 21, NULL),('202101', 'a1004', 21, NULL),('202101', 'a1001', 22, 100),('202101', 'a1002', 22, 100),('202101', 'a1003', 22, NULL),('202101', 'a1004', 22, NULL);
UNLOCK TABLES;
COMMIT;
