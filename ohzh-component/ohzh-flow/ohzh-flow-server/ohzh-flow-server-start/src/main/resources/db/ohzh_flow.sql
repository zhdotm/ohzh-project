-- ohzh_flow.ACT_EXTRA_BUSINESS_TYPE definition

CREATE TABLE `ACT_EXTRA_BUSINESS_TYPE`
(
    `ID`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT '物理主键',
    `TYPE_ID`       varchar(45)                                                  NOT NULL COMMENT '业务类型逻辑主键',
    `TYPE_NAME`     varchar(45)                                                  NOT NULL COMMENT '业务类型名称',
    `TYPE_DESC`     tinytext                                                              DEFAULT NULL COMMENT '业务类型描述',
    `EXTRA_ATTRS`   text                                                                  DEFAULT NULL COMMENT '额外信息',
    `CREATOR_ID`    varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '创建人ID',
    `CREATED_BY`    varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '创建人姓名',
    `CREATED_TIME`  datetime                                                              DEFAULT current_timestamp() COMMENT '创建时间',
    `MODIFIER_ID`   varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '更新人id',
    `MODIFIED_BY`   varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '更新人名称',
    `MODIFIED_TIME` datetime                                                              DEFAULT current_timestamp() COMMENT '更新时间',
    `IS_DELETED`    varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '逻辑删除标志位',
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='业务类型的信息';


-- ohzh_flow.ACT_EXTRA_INDEPENDENT_FORM definition

CREATE TABLE `ACT_EXTRA_INDEPENDENT_FORM`
(
    `ID`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT '物理主键',
    `FORM_ID`       varchar(45)                                                  NOT NULL COMMENT '表单逻辑主键',
    `FORM_KEY`      varchar(45)                                                  NOT NULL COMMENT '表单的KEY',
    `FORM_VERSION`  int(11) NOT NULL DEFAULT 1 COMMENT '表单的版本',
    `FORM_NAME`     varchar(45)                                                  NOT NULL COMMENT '表单名称',
    `FORM_JSON`     text                                                         NOT NULL COMMENT '表单的JSON串',
    `FORM_DESC`     tinytext                                                     NOT NULL DEFAULT '' COMMENT '描述',
    `EXTRA_ATTRS`   text                                                                  DEFAULT NULL COMMENT '额外信息',
    `CREATOR_ID`    varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '创建人ID',
    `CREATED_BY`    varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '创建人姓名',
    `CREATED_TIME`  datetime                                                              DEFAULT current_timestamp() COMMENT '创建时间',
    `MODIFIER_ID`   varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '更新人id',
    `MODIFIED_BY`   varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '更新人名称',
    `MODIFIED_TIME` datetime                                                              DEFAULT current_timestamp() COMMENT '更新时间',
    `IS_DELETED`    varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '逻辑删除标志位',
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='独立表单信息';


-- ohzh_flow.ACT_EXTRA_PROC_CATEGORY definition

CREATE TABLE `ACT_EXTRA_PROC_CATEGORY`
(
    `ID`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT '物理主键',
    `CATEGORY_ID`   varchar(45)                                                  NOT NULL COMMENT '流程分类逻辑主键',
    `CATEGORY_NAME` varchar(45)                                                  NOT NULL COMMENT '分类名称',
    `ICON_URL`      varchar(255)                                                 NOT NULL DEFAULT '' COMMENT '分类展示图标',
    `CATEGORY_DESC` tinytext                                                              DEFAULT NULL COMMENT '流程分类描述',
    `EXTRA_ATTRS`   text                                                                  DEFAULT NULL COMMENT '额外信息',
    `CREATOR_ID`    varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '创建人ID',
    `CREATED_BY`    varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '创建人姓名',
    `CREATED_TIME`  datetime                                                              DEFAULT current_timestamp() COMMENT '创建时间',
    `MODIFIER_ID`   varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '更新人id',
    `MODIFIED_BY`   varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '更新人名称',
    `MODIFIED_TIME` datetime                                                              DEFAULT current_timestamp() COMMENT '更新时间',
    `IS_DELETED`    varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '逻辑删除标志位',
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='流程分类';


-- ohzh_flow.ACT_EXTRA_PROC_DEF definition

CREATE TABLE `ACT_EXTRA_PROC_DEF`
(
    `ID`               bigint(20) NOT NULL AUTO_INCREMENT COMMENT '物理主键',
    `DEF_ID`           varchar(200)                                                 NOT NULL COMMENT 'CAMUNDA中的流程定义ID，关联到ACT_RE_PROCDEF',
    `DEF_KEY`          varchar(200)                                                 NOT NULL COMMENT 'CAMUNDA中的流程定义KEY，关联到ACT_RE_PROCDEF的KEY',
    `DEF_VERSION`      int(11) NOT NULL DEFAULT 1 COMMENT 'CAMUNDA中的流程定义版本，关联到ACT_RE_PROCDEF的VERSION',
    `DEF_NAME`         varchar(45)                                                  NOT NULL COMMENT '流程定义名称',
    `DEF_STATUS`       tinyint(1) NOT NULL DEFAULT 1 COMMENT '流程定义的状态，0-禁用 1-启用',
    `PROC_CATEGORY_ID` varchar(45)                                                  NOT NULL COMMENT '流程分类ID',
    `BUSINESS_TYPE_ID` varchar(255)                                                 NOT NULL DEFAULT '' COMMENT '当前流程定义所属的业务类型，用于关联具体业务',
    `ICON_URL`         varchar(255)                                                 NOT NULL DEFAULT '' COMMENT '分类展示图标',
    `EXTRA_ATTRS`      text                                                                  DEFAULT NULL COMMENT '额外信息',
    `CREATOR_ID`       varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '创建人ID',
    `CREATED_BY`       varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '创建人姓名',
    `CREATED_TIME`     datetime                                                              DEFAULT current_timestamp() COMMENT '创建时间',
    `MODIFIER_ID`      varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '更新人id',
    `MODIFIED_BY`      varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '更新人名称',
    `MODIFIED_TIME`    datetime                                                              DEFAULT current_timestamp() COMMENT '更新时间',
    `IS_DELETED`       varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '逻辑删除标志位',
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='流程定义';


-- ohzh_flow.ACT_EXTRA_PROC_INST definition

CREATE TABLE `ACT_EXTRA_PROC_INST`
(
    `ID`                     bigint(20) NOT NULL AUTO_INCREMENT COMMENT '物理主键',
    `BUSINESS_KEY`           varchar(45)                                                  NOT NULL COMMENT '流程实例逻辑主键，CAMUNDA中的BUSINESS_KEY',
    `PROC_INST_ID`           varchar(45)                                                  NOT NULL COMMENT 'CAMUNDA中的流程实例ID',
    `PROC_INST_NAME`         varchar(45)                                                  NOT NULL COMMENT '流程实例名称',
    `PROC_INST_DESC`         tinytext                                                     NOT NULL DEFAULT '' COMMENT '描述信息',
    `BUSINESS_TYPE_ID`       varchar(45)                                                  NOT NULL COMMENT '业务类型逻辑主键',
    `BUSINESS_TYPE_NAME`     varchar(45)                                                  NOT NULL COMMENT '业务类型名称',
    `PROC_CATEGORY_ID`       varchar(45)                                                  NOT NULL COMMENT '流程分类逻辑主键',
    `PROC_CATEGORY_NAME`     varchar(45)                                                  NOT NULL COMMENT '分类名称',
    `PROC_CATEGORY_ICON_URL` varchar(255)                                                 NOT NULL DEFAULT '' COMMENT '分类展示图标',
    `PROC_DEF_ID`            varchar(200)                                                 NOT NULL COMMENT 'CAMUNDA中的流程定义ID，关联到ACT_RE_PROCDEF',
    `PROC_DEF_KEY`           varchar(200)                                                 NOT NULL COMMENT 'CAMUNDA中的流程定义KEY，关联到ACT_RE_PROCDEF的KEY',
    `PROC_DEF_VERSION`       int(11) NOT NULL DEFAULT 1 COMMENT 'CAMUNDA中的流程定义版本，关联到ACT_RE_PROCDEF的VERSION',
    `PROC_DEF_NAME`          varchar(45)                                                  NOT NULL COMMENT '流程定义名称',
    `PROC_DEF_ICON_URL`      varchar(255)                                                 NOT NULL DEFAULT '' COMMENT '分类展示图标',
    `EXTRA_ATTRS`            text                                                                  DEFAULT NULL COMMENT '额外信息',
    `CREATOR_ID`             varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '创建人ID',
    `CREATED_BY`             varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '创建人姓名',
    `CREATED_TIME`           datetime                                                              DEFAULT current_timestamp() COMMENT '创建时间',
    `MODIFIER_ID`            varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '更新人id',
    `MODIFIED_BY`            varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci          DEFAULT NULL COMMENT '更新人名称',
    `MODIFIED_TIME`          datetime                                                              DEFAULT current_timestamp() COMMENT '更新时间',
    `IS_DELETED`             varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '逻辑删除标志位',
    PRIMARY KEY (`ID`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_bin COMMENT ='流程实例信息';