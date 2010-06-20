-- phpMyAdmin SQL Dump
-- version 2.9.2
-- http://www.phpmyadmin.net
-- 
-- 主机: localhost
-- 生成日期: 2010 年 06 月 09 日 12:36
-- 服务器版本: 5.0.27
-- PHP 版本: 5.2.1
-- 
-- 数据库: `booking`
-- 

-- --------------------------------------------------------

-- 
-- 表的结构 `dept`
-- 

CREATE TABLE `dept` (
  `id` varchar(32) NOT NULL,
  `version` int(11) default NULL,
  `NAME` varchar(50) default NULL,
  `STATUS` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `dept`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `role`
-- 

CREATE TABLE `role` (
  `id` varchar(32) NOT NULL,
  `version` int(11) default NULL,
  `NAME` varchar(64) default NULL,
  `MEMO` varchar(128) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `role`
-- 

INSERT INTO `role` VALUES ('1', NULL, '信息技術部', '信息技術部');

-- --------------------------------------------------------

-- 
-- 表的结构 `rolefunction`
-- 

CREATE TABLE `rolefunction` (
  `id` varchar(32) NOT NULL,
  `version` int(11) default NULL,
  `ROLEID` int(11) default NULL,
  `FUNCTIONID` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `rolefunction`
-- 

INSERT INTO `rolefunction` VALUES ('1', 0, 1, 1);
INSERT INTO `rolefunction` VALUES ('2', NULL, 1, 2);
INSERT INTO `rolefunction` VALUES ('3', NULL, 1, 3);

-- --------------------------------------------------------

-- 
-- 表的结构 `systemfunction`
-- 

CREATE TABLE `systemfunction` (
  `id` varchar(32) NOT NULL,
  `version` int(11) default NULL,
  `STATUS` int(11) default NULL,
  `URL` varchar(64) default NULL,
  `PERFUNC` int(11) default NULL,
  `FUNCLEVEL` int(11) default NULL,
  `FUNCNAME` varchar(64) default NULL,
  `SEQ` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `systemfunction`
-- 

INSERT INTO `systemfunction` VALUES ('1', NULL, 0, '#', 0, 1, '人事管理', 1);
INSERT INTO `systemfunction` VALUES ('2', NULL, 0, 'user/key/list', 1, 2, '人員資料管理', 1);
INSERT INTO `systemfunction` VALUES ('3', NULL, 0, 'dept/key/list', 1, 2, '部門管理', 1);

-- --------------------------------------------------------

-- 
-- 表的结构 `userinfo`
-- 

CREATE TABLE `userinfo` (
  `id` varchar(32) NOT NULL,
  `version` int(11) default NULL,
  `STATUS` int(11) default NULL,
  `DEPTID` int(11) default NULL,
  `USERNAME` varchar(128) default NULL,
  `PASSWORD` varchar(128) default NULL,
  `LASTTIME` datetime default NULL,
  `LASTIP` varchar(128) default NULL,
  `CREATTIME` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `userinfo`
-- 

INSERT INTO `userinfo` VALUES ('1', 0, 0, 0, 'admin', '0a113ef6b61820daa5611c870ed8d5ee', '2010-06-09 16:54:22', '127.0.0.1', '2010-06-05 12:43:11');

-- --------------------------------------------------------

-- 
-- 表的结构 `userrole`
-- 

CREATE TABLE `userrole` (
  `id` varchar(32) NOT NULL,
  `version` int(11) default NULL,
  `ROLEID` int(11) default NULL,
  `USERID` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `userrole`
-- 

INSERT INTO `userrole` VALUES ('1', NULL, 1, 1);
INSERT INTO `userrole` VALUES ('2', NULL, 2, 1);
