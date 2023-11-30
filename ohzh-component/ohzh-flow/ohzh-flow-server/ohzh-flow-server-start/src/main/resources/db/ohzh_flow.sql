create table if not exists ohzh_flow.ACT_EXTRA_BUSINESS_TYPE
(
    ID
    bigint
    auto_increment
    comment
    '物理主键'
    primary
    key,
    TYPE_ID
    varchar
(
    45
) not null comment '业务类型逻辑主键',
    TYPE_NAME varchar
(
    45
) not null comment '业务类型名称',
    TYPE_DESC tinytext null comment '业务类型描述',
    EXTRA_ATTRS text null comment '额外信息',
    CREATOR_ID varchar
(
    45
) collate utf8mb4_general_ci null comment '创建人ID',
    CREATED_BY varchar
(
    45
) collate utf8mb4_general_ci null comment '创建人姓名',
    CREATED_TIME datetime default CURRENT_TIMESTAMP null comment '创建时间',
    MODIFIER_ID varchar
(
    45
) collate utf8mb4_general_ci null comment '更新人id',
    MODIFIED_BY varchar
(
    45
) collate utf8mb4_general_ci null comment '更新人名称',
    MODIFIED_TIME datetime default CURRENT_TIMESTAMP null comment '更新时间',
    IS_DELETED varchar
(
    45
) collate utf8mb4_general_ci default '0' not null comment '逻辑删除标志位'
    )
    comment '业务类型的信息' engine = InnoDB
    collate = utf8mb4_bin;

create table if not exists ohzh_flow.ACT_EXTRA_INDEPENDENT_FORM
(
    ID
    bigint
    auto_increment
    comment
    '物理主键'
    primary
    key,
    FORM_ID
    varchar
(
    45
) not null comment '表单逻辑主键',
    FORM_KEY varchar
(
    45
) not null comment '表单的KEY',
    FORM_VERSION int default 1 not null comment '表单的版本',
    FORM_NAME varchar
(
    45
) not null comment '表单名称',
    FORM_JSON text not null comment '表单的JSON串',
    FORM_DESC tinytext null comment '描述',
    EXTRA_ATTRS text null comment '额外信息',
    CREATOR_ID varchar
(
    45
) collate utf8mb4_general_ci null comment '创建人ID',
    CREATED_BY varchar
(
    45
) collate utf8mb4_general_ci null comment '创建人姓名',
    CREATED_TIME datetime default CURRENT_TIMESTAMP null comment '创建时间',
    MODIFIER_ID varchar
(
    45
) collate utf8mb4_general_ci null comment '更新人id',
    MODIFIED_BY varchar
(
    45
) collate utf8mb4_general_ci null comment '更新人名称',
    MODIFIED_TIME datetime default CURRENT_TIMESTAMP null comment '更新时间',
    IS_DELETED varchar
(
    45
) collate utf8mb4_general_ci default '0' not null comment '逻辑删除标志位'
    )
    comment '独立表单信息' engine = InnoDB
    collate = utf8mb4_bin;

create table if not exists ohzh_flow.ACT_EXTRA_PROC_CATEGORY
(
    ID
    bigint
    auto_increment
    comment
    '物理主键'
    primary
    key,
    CATEGORY_ID
    varchar
(
    45
) not null comment '流程分类逻辑主键',
    CATEGORY_NAME varchar
(
    45
) not null comment '分类名称',
    ICON_URL varchar
(
    255
) default '' not null comment '分类展示图标',
    CATEGORY_DESC tinytext null comment '流程分类描述',
    EXTRA_ATTRS text null comment '额外信息',
    CREATOR_ID varchar
(
    45
) collate utf8mb4_general_ci null comment '创建人ID',
    CREATED_BY varchar
(
    45
) collate utf8mb4_general_ci null comment '创建人姓名',
    CREATED_TIME datetime default CURRENT_TIMESTAMP null comment '创建时间',
    MODIFIER_ID varchar
(
    45
) collate utf8mb4_general_ci null comment '更新人id',
    MODIFIED_BY varchar
(
    45
) collate utf8mb4_general_ci null comment '更新人名称',
    MODIFIED_TIME datetime default CURRENT_TIMESTAMP null comment '更新时间',
    IS_DELETED varchar
(
    45
) collate utf8mb4_general_ci default '0' not null comment '逻辑删除标志位'
    )
    comment '流程分类' engine = InnoDB
    collate = utf8mb4_bin;

create table if not exists ohzh_flow.ACT_EXTRA_PROC_DEF
(
    ID
    bigint
    auto_increment
    comment
    '物理主键'
    primary
    key,
    DEF_ID
    varchar
(
    200
) not null comment 'CAMUNDA中的流程定义ID，关联到ACT_RE_PROCDEF',
    DEF_KEY varchar
(
    200
) not null comment 'CAMUNDA中的流程定义KEY，关联到ACT_RE_PROCDEF的KEY',
    DEF_VERSION int default 1 not null comment 'CAMUNDA中的流程定义版本，关联到ACT_RE_PROCDEF的VERSION',
    DEF_NAME varchar
(
    45
) not null comment '流程定义名称',
    DEF_STATUS tinyint
(
    1
) default 1 not null comment '流程定义的状态，0-禁用 1-启用',
    PROC_CATEGORY_ID varchar
(
    45
) not null comment '流程分类ID',
    BUSINESS_TYPE_ID varchar
(
    255
) default '' not null comment '当前流程定义所属的业务类型，用于关联具体业务',
    ICON_URL varchar
(
    255
) default '' not null comment '分类展示图标',
    EXTRA_ATTRS text null comment '额外信息',
    DEF_DESC tinytext null comment '流程定义描述',
    CREATOR_ID varchar
(
    45
) collate utf8mb4_general_ci null comment '创建人ID',
    CREATED_BY varchar
(
    45
) collate utf8mb4_general_ci null comment '创建人姓名',
    CREATED_TIME datetime default CURRENT_TIMESTAMP null comment '创建时间',
    MODIFIER_ID varchar
(
    45
) collate utf8mb4_general_ci null comment '更新人id',
    MODIFIED_BY varchar
(
    45
) collate utf8mb4_general_ci null comment '更新人名称',
    MODIFIED_TIME datetime default CURRENT_TIMESTAMP null comment '更新时间',
    IS_DELETED varchar
(
    45
) collate utf8mb4_general_ci default '0' not null comment '逻辑删除标志位'
    )
    comment '流程定义' engine = InnoDB
    collate = utf8mb4_bin;

create table if not exists ohzh_flow.ACT_EXTRA_PROC_INST
(
    ID
    bigint
    auto_increment
    comment
    '物理主键'
    primary
    key,
    BUSINESS_KEY
    varchar
(
    45
) not null comment '流程实例逻辑主键，CAMUNDA中的BUSINESS_KEY',
    PROC_INST_ID varchar
(
    45
) not null comment 'CAMUNDA中的流程实例ID',
    PROC_INST_NAME varchar
(
    45
) not null comment '流程实例名称',
    PROC_INST_DESC tinytext null comment '描述信息',
    BUSINESS_TYPE_ID varchar
(
    45
) not null comment '业务类型逻辑主键',
    BUSINESS_TYPE_SNAPSHOT text not null comment '业务类型快照',
    PROC_CATEGORY_ID varchar
(
    45
) not null comment '流程分类逻辑主键',
    PROC_CATEGORY_SNAPSHOT text not null comment '流程分类快照',
    PROC_DEF_ID varchar
(
    45
) not null comment 'CAMUNDA中的流程定义ID，关联到ACT_RE_PROCDEF',
    PROC_DEF_SNAPSHOT text not null comment '流程定义快照',
    EXTRA_ATTRS text null comment '额外信息',
    CREATOR_ID varchar
(
    45
) collate utf8mb4_general_ci null comment '创建人ID',
    CREATED_BY varchar
(
    45
) collate utf8mb4_general_ci null comment '创建人姓名',
    CREATED_TIME datetime default CURRENT_TIMESTAMP null comment '创建时间',
    MODIFIER_ID varchar
(
    45
) collate utf8mb4_general_ci null comment '更新人id',
    MODIFIED_BY varchar
(
    45
) collate utf8mb4_general_ci null comment '更新人名称',
    MODIFIED_TIME datetime default CURRENT_TIMESTAMP null comment '更新时间',
    IS_DELETED varchar
(
    45
) collate utf8mb4_general_ci default '0' not null comment '逻辑删除标志位'
    )
    comment '流程实例信息' engine = InnoDB
    collate = utf8mb4_bin;

