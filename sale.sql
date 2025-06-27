/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80042 (8.0.42)
 Source Host           : localhost:3306
 Source Schema         : user_db

 Target Server Type    : MySQL
 Target Server Version : 80042 (8.0.42)
 File Encoding         : 65001

 Date: 27/06/2025 14:22:47
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sale
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `salename` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `startdate` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `enddate` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sale
-- ----------------------------
INSERT INTO `sale` VALUES (1, '火锅店新老客户80%折扣优惠', '2025.6.15', '2025.7.25', '进行中');
INSERT INTO `sale` VALUES (2, '商场促销满100-20', '2025.1.2', '2025.3.7', '已结束');
INSERT INTO `sale` VALUES (3, '服装店满300-50', '2025.8.9', '2025.9.9', '未开始');
INSERT INTO `sale` VALUES (4, 'CSDN程序员节会员90%折扣', '2025.10.24', '2025.10.24', '未开始');
INSERT INTO `sale` VALUES (5, '春季大促', '2023.3.15', '2023.4.13', '已结束');
INSERT INTO `sale` VALUES (6, '夏季清仓', '2023.6.1', '2023.6.30', '已结束');
INSERT INTO `sale` VALUES (7, '国庆特惠', '2023.10.1', '2023.10.7', '已结束');
INSERT INTO `sale` VALUES (8, '黑五狂欢', '2023.11.24', '2023.11.28', '已结束');
INSERT INTO `sale` VALUES (9, '开学季优惠', '2024.2.25', '2024.3.10', '已结束');
INSERT INTO `sale` VALUES (10, '新年焕新', '2025.1.8', '2025.2.5', '已结束');
INSERT INTO `sale` VALUES (11, '情人节专享', '2025.2.10', '2025.2.16', '已结束');
INSERT INTO `sale` VALUES (12, '妇女节活动', '2025.3.3', '2025.3.12', '已结束');
INSERT INTO `sale` VALUES (13, '618年中庆', '2024.6.1', '2024.6.20', '已结束');
INSERT INTO `sale` VALUES (14, '劳动节福利', '2025.4.25', '2025.5.7', '已结束');
INSERT INTO `sale` VALUES (15, '母亲节感恩', '2025.5.6', '2025.5.14', '已结束');
INSERT INTO `sale` VALUES (16, '儿童节专场', '2025.5.25', '2025.6.3', '已结束');
INSERT INTO `sale` VALUES (17, '端午节特惠', '2025.6.5', '2025.6.15', '已结束');
INSERT INTO `sale` VALUES (18, '暑期大放送', '2025.7.1', '2025.8.31', '未开始');
INSERT INTO `sale` VALUES (19, '会员日专属', '2025.8.8', '2025.8.18', '未开始');
INSERT INTO `sale` VALUES (20, '中秋特卖', '2024.9.5', '2024.9.20', '未开始');
INSERT INTO `sale` VALUES (21, '阿里云云服务器大促', '2025.6.3', '2025.7.9', '进行中');

SET FOREIGN_KEY_CHECKS = 1;
