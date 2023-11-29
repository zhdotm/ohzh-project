/**
 * ACT_RU_*：这个前缀的表表示流程运行时，其中包含了流程实例，任务，变量，Job等运行中的数据。
 * Camunda只在流程实例执行过程中保存这些数据，在流程结束时就会删除这些记录，这样运行时表的数据量最小，可以最快运行，共有15张表。
 */
package io.github.zhdotm.ohzh.flow.server.infrastructure.dataobject.camunda.ru;