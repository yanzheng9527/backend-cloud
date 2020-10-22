--liquibase formatted sql

--changeset randy:3
SET FOREIGN_KEY_CHECKS=0;

INSERT INTO `user` VALUES ('02b9044ecb6b412c8da101cde0ae125e', 'leon', '1111', NULL, NULL, NULL, NULL, NULL, NULL, '111', 'leon@123.com', NULL, 'NORMAL', NULL, NULL, NULL, NULL, NULL, NULL, current_timestamp, NULL);
INSERT INTO `user` VALUES ('030043136a604c498e6cd5b4cc5aeaf5', 'randy', '2222', NULL, NULL, NULL, NULL, NULL, NULL, '222', 'randy@123.com', NULL, 'NORMAL', NULL, NULL, NULL, NULL, NULL, NULL, current_timestamp, NULL);
INSERT INTO `user` VALUES ('033955fd8b42498d978d0628d89d6f46', 'lyon', '3333', NULL, NULL, NULL, NULL, NULL, NULL, '333', 'lyon@123.com', NULL, 'NORMAL', NULL, NULL, NULL, NULL, NULL, NULL, current_timestamp, NULL);
INSERT INTO `user` VALUES ('root', 'root', '4444', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 'NORMAL', '444', 'root@123.com', NULL, NULL, NULL, NULL, current_timestamp, NULL);

INSERT INTO `role` VALUES ('bbc1cd9e2fff4ce3806f3ec9cfdade60', '游客', 'NORMAL', 'CUSTOM', NULL, NULL, current_timestamp);
INSERT INTO `role` VALUES ('ebaee73daec84dbe8b17506791952236', '普通用户', 'NORMAL', 'CUSTOM', NULL, NULL, current_timestamp);
INSERT INTO `role` VALUES ('superAdmin', '系统超级管理员', 'ROOT', 'DEFAULT', NULL, '系统默认角色,拥有系统访问的最大权限', current_timestamp);

INSERT INTO `user_role_rel` VALUES ('564beea72c4342e3baa15f5c1b094280', '02b9044ecb6b412c8da101cde0ae125e', 'bbc1cd9e2fff4ce3806f3ec9cfdade60');
INSERT INTO `user_role_rel` VALUES ('a972981ea5194a9f827fd37c69227871', '030043136a604c498e6cd5b4cc5aeaf5', 'ebaee73daec84dbe8b17506791952236');
INSERT INTO `user_role_rel` VALUES ('721e6b75b1cf4ab686df07f86fabd4f6', '033955fd8b42498d978d0628d89d6f46', 'ebaee73daec84dbe8b17506791952236');
INSERT INTO `user_role_rel` VALUES ('eefdc3a9084611e99fb802420aff0154', 'root', 'superAdmin');

INSERT INTO `resource` VALUES ('88f8787b64d811e8bfabcb1f38bc09f6', '权限管理', 'APPLICATION', '权限管理', NULL, 'abf680bf073e11e99ac102420aff01ce', 0, 'url1');
INSERT INTO `resource` VALUES ('0651aa3f43034643903f583300a30cea', '用户管理', 'MENU', '权限管理/用户管理', '88f8787b64d811e8bfabcb1f38bc09f6', 'abf680bf073e11e99ac102420aff01ce', 1, 'url2');
INSERT INTO `resource` VALUES ('02206eabf472442389c6f1d2df45ea7f', '用户添加', 'BUTTON', '权限管理/用户管理/用户添加', '0651aa3f43034643903f583300a30cea', 'abf680bf073e11e99ac102420aff01ce', 1, 'url3');
INSERT INTO `resource` VALUES ('04e931ff2e6d4fd79d3bfc323b219b2a', '用户查询', 'API', '权限管理/角色管理', 'abf680bf073e11e99ac102420aff01ce', 'abf680bf073e11e99ac102420aff01ce', 1, 'url4');

INSERT INTO `permission` VALUES ('00588572f4c24d0f896d9541311d1f09', '001001', '0651aa3f43034643903f583300a30cea', '是否可见', 'NORMAL', 'UI');
INSERT INTO `permission` VALUES ('021b32d405ab4d3191c6cfde83aedee5', '001002', '02206eabf472442389c6f1d2df45ea7f', '是否可见', 'NORMAL', 'UI');
INSERT INTO `permission` VALUES ('05ec0e02f6ab4a2ca80358fd669061a2', '001003', '04e931ff2e6d4fd79d3bfc323b219b2a', 'GET', 'NORMAL', 'API');

INSERT INTO `authorization` VALUES ('06cf1469c79b48d492db384e566ae727', 'bbc1cd9e2fff4ce3806f3ec9cfdade60', 'ROLE', 'yummy-map', 'ENTERPRISE', '00588572f4c24d0f896d9541311d1f09', NULL);
INSERT INTO `authorization` VALUES ('0a59de392ce740abbf30160505757ee6', 'ebaee73daec84dbe8b17506791952236', 'ROLE', 'yummy-map', 'ENTERPRISE', '00588572f4c24d0f896d9541311d1f09', NULL);
INSERT INTO `authorization` VALUES ('228b83f5528c4ebd879032ebbf754b19', 'ebaee73daec84dbe8b17506791952236', 'ROLE', 'yummy-map', 'ENTERPRISE', '021b32d405ab4d3191c6cfde83aedee5', NULL);
INSERT INTO `authorization` VALUES ('330f9c265a0a49e1a81493fdaf3311a2', 'ebaee73daec84dbe8b17506791952236', 'ROLE', 'yummy-map', 'ENTERPRISE', '05ec0e02f6ab4a2ca80358fd669061a2', NULL);

-- INSERT INTO `menu` VALUES ('0651aa3f43034643903f583300a30cea', '资源管理', NULL);
-- INSERT INTO `menu` VALUES ('02206eabf472442389c6f1d2df45ea7f', '用户管理', NULL);
-- INSERT INTO `menu` VALUES ('04e931ff2e6d4fd79d3bfc323b219b2a', '角色管理', NULL);
--
-- INSERT INTO `button` VALUES ('ef4bf50458a240f194f2da406894428f', '资源增加', NULL);
-- INSERT INTO `button` VALUES ('ff2980d45d6e4d0789246f0774a1b658', '用户增加', NULL);
-- INSERT INTO `button` VALUES ('ff9873a252514a81854e59c0a0f9b388', '角色增加', NULL);
--
-- INSERT INTO `api` VALUES ('939eaac84260454b8b56c606008a765e', '资源查询', 'url1');
-- INSERT INTO `api` VALUES ('94cdee0d31a44545826d6c4a5d2d21a3', '用户查询', 'url2');
-- INSERT INTO `api` VALUES ('a04776601e36466d9a6bd53e3c98290b', '角色查询', 'url3');

INSERT INTO `application` VALUES ('abf680bf073e11e99ac102420aff01ce', '权限管理', 'DEFAULT', '权限管理', 'ultra-permission');

SET FOREIGN_KEY_CHECKS = 1;











