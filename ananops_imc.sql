/*
 Navicat Premium Data Transfer

 Source Server         : mysql5.7
 Source Server Type    : MySQL
 Source Server Version : 50725
 Source Host           : localhost:3306
 Source Schema         : ananops_imc

 Target Server Type    : MySQL
 Target Server Version : 50725
 File Encoding         : 65001

 Date: 27/11/2019 10:56:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for imc_device_order
-- ----------------------------
DROP TABLE IF EXISTS `imc_device_order`;
CREATE TABLE `imc_device_order`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `creator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `last_operator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `inspection_item_id` bigint(20) DEFAULT NULL COMMENT '对应的巡检子项目的ID',
  `maintenance_task_id` bigint(20) DEFAULT NULL COMMENT '对应的巡检子项目产生的维修维护工单的ID',
  `device_id` bigint(20) DEFAULT NULL COMMENT '设备的ID',
  `cost` decimal(10, 3) DEFAULT NULL COMMENT '当前订单花费',
  `device_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '设备类型',
  `manufacture` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '设别生产商',
  `device_model` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '设备型号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for imc_exception_log
-- ----------------------------
DROP TABLE IF EXISTS `imc_exception_log`;
CREATE TABLE `imc_exception_log`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `application_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '系统应用名',
  `exception_simple_name` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '异常类型',
  `exception_message` varchar(4500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '异常信息(通过exception.getMessage()获取到的内容)',
  `exception_cause` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '异常原因(通过exception.getCause()获取到的内容)',
  `exception_stack` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '异常堆栈信息',
  `creator` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT '' COMMENT '操作者姓名',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '操作者id',
  `create_time` datetime(0) DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for imc_inspection_item
-- ----------------------------
DROP TABLE IF EXISTS `imc_inspection_item`;
CREATE TABLE `imc_inspection_item`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `creator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `last_operator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `device_id` bigint(20) DEFAULT NULL COMMENT '被巡检的设备ID',
  `inspection_task_id` bigint(20) DEFAULT NULL COMMENT '从属的巡检任务的ID',
  `device_status` int(2) DEFAULT NULL COMMENT '被巡检的设备的状态（0.故障，1.正常）',
  `exception_description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '故障描述',
  `exception_level` int(5) DEFAULT NULL COMMENT '故障等级',
  `scheduled_start_time` datetime(0) DEFAULT NULL COMMENT '计划开始时间',
  `actual_start_time` datetime(0) DEFAULT NULL COMMENT '实际开始时间',
  `scheduled_finish_time` datetime(0) DEFAULT NULL COMMENT '计划完成时间',
  `actual_finish_time` datetime(0) DEFAULT NULL COMMENT '实际完成时间',
  `deadline` datetime(0) DEFAULT NULL COMMENT '最迟完成时间',
  `maintenance_task_id` bigint(20) DEFAULT NULL COMMENT '巡检产生的维修维护工单对应的id',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '巡检结果描述',
  `status` int(10) DEFAULT NULL COMMENT '巡检状态',
  `device_latitude` decimal(10, 6) DEFAULT NULL COMMENT '被巡检设备的位置，纬度',
  `device_longitude` decimal(10, 6) DEFAULT NULL COMMENT '被巡检设备的位置，经度',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for imc_inspection_item_info
-- ----------------------------
DROP TABLE IF EXISTS `imc_inspection_item_info`;
CREATE TABLE `imc_inspection_item_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `creator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `last_operator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `project_id` bigint(20) DEFAULT NULL COMMENT '对应的项目ID',
  `device_id` bigint(20) DEFAULT NULL COMMENT '设备ID',
  `device_type` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '设别类型',
  `device_latitude` decimal(10, 6) DEFAULT NULL COMMENT '设备位置，纬度',
  `device_longitude` decimal(10, 6) DEFAULT NULL COMMENT '设别位置，经度',
  `inspect_frequency` int(5) DEFAULT NULL COMMENT '合同上规定的巡检频率',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for imc_inspection_review
-- ----------------------------
DROP TABLE IF EXISTS `imc_inspection_review`;
CREATE TABLE `imc_inspection_review`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `creator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `last_operator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `inspection_task_id` bigint(20) DEFAULT NULL COMMENT '对应的巡检任务ID',
  `principal_id` bigint(20) DEFAULT NULL COMMENT '项目负责人ID',
  `score` int(5) DEFAULT NULL COMMENT '服务评级',
  `contents` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '服务评论',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for imc_inspection_task
-- ----------------------------
DROP TABLE IF EXISTS `imc_inspection_task`;
CREATE TABLE `imc_inspection_task`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `creator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `last_operator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `principal_id` bigint(20) DEFAULT NULL COMMENT '项目负责人ID',
  `facilitator_id` bigint(20) DEFAULT NULL COMMENT '服务商ID',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目ID',
  `location` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '巡检位置信息',
  `status` int(10) DEFAULT NULL COMMENT '当前巡检任务进度',
  `total_cost` decimal(10, 3) DEFAULT NULL COMMENT '本次巡检总花费',
  `maintenance_cost` decimal(10, 3) DEFAULT NULL COMMENT '巡检产生的维修维护费用',
  `scheduled_start_time` datetime(0) DEFAULT NULL COMMENT '计划起始时间',
  `actual_start_time` datetime(0) DEFAULT NULL COMMENT '实际开始时间',
  `scheduled_finish_time` datetime(0) DEFAULT NULL COMMENT '计划完成时间',
  `actual_finish_time` datetime(0) DEFAULT NULL COMMENT '实际完成时间',
  `deadline` datetime(0) DEFAULT NULL COMMENT '最迟完成时间',
  `inspection_type` int(2) DEFAULT NULL COMMENT '巡检类型（1.按合同产生的巡检，2.甲方负责人主动发出的巡检）',
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for imc_maintenance_task
-- ----------------------------
DROP TABLE IF EXISTS `imc_maintenance_task`;
CREATE TABLE `imc_maintenance_task`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `creator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `last_operator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `inspection_item_id` bigint(20) DEFAULT NULL COMMENT '对应的巡检子项目ID',
  `device_id` bigint(20) DEFAULT NULL COMMENT '巡检查出的故障设备的ID',
  `level` int(5) DEFAULT NULL COMMENT '故障等级',
  `device_latitude` decimal(10, 6) DEFAULT NULL COMMENT '故障设备的位置，纬度',
  `device_longitude` decimal(10, 6) DEFAULT NULL COMMENT '故障设备的位置，经度',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '故障描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for imc_permits_info
-- ----------------------------
DROP TABLE IF EXISTS `imc_permits_info`;
CREATE TABLE `imc_permits_info`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `version` int(11) DEFAULT NULL COMMENT '版本号',
  `creator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建人',
  `creator_id` bigint(20) DEFAULT NULL COMMENT '创建人ID',
  `created_time` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `last_operator` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最近操作人',
  `last_operator_id` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `update_time` datetime(0) DEFAULT NULL COMMENT '更新时间',
  `project_id` bigint(20) DEFAULT NULL COMMENT '项目ID',
  `permits_id` bigint(20) DEFAULT NULL COMMENT '证照ID',
  `permits_name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '证照名称',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '证照描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
