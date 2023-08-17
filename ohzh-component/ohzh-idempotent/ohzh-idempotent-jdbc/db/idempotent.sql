create table idempotent
(
    id              bigint unsigned auto_increment comment '物理主键'
        primary key,
    biz_id          varchar(200) default 'default'         not null comment '业务ID',
    idem_key        varchar(500)                           not null comment '幂等key',
    method_name     varchar(200)                           not null comment '方法名',
    return_obj_blob blob null comment '执行结果',
    is_done         tinyint      default 0                 not null comment '执行是否完成: 是: 1, 否: 0',
    create_time     timestamp    default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time     timestamp    default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_deleted      bigint       default 0                 not null comment '逻辑删除',
    constraint biz_id_idem_key_is_deleted_uindex
        unique (biz_id, idem_key, is_deleted)
) comment '幂等表' engine=InnoDB charset=utf8mb4;

