package io.github.zhdotm.ohzh.flow.server.infrastructure.listener.execution;

import org.camunda.bpm.engine.delegate.ExecutionListener;

/**
 * ExecutionListener 的作用是监听流程实例的执行事件。
 * 它可以捕获流程实例的启动、结束、活动开始、活动结束等事件，并在这些事件发生时执行特定的逻辑。
 *
 * @author zhihao.mao
 */

public interface IExecutionListener extends ExecutionListener {

}
