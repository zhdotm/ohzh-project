package io.github.zhdotm.ohzh.flow.server.infrastructure.listener.task;

import org.camunda.bpm.engine.delegate.TaskListener;

/**
 * TaskListener 是 Camunda BPM 中的一个重要组件，用于处理与任务相关的业务逻辑。
 * 它可以监听任务的创建、完成、删除等事件，并在这些事件发生时执行特定的操作。
 * <p>
 * TaskListener 可以用于以下场景：
 * <p>
 * 监听任务事件：TaskListener 可以监听任务的创建、完成、删除等事件，并在这些事件发生时触发特定的逻辑，例如发送通知、更新任务状态等。
 * 执行业务逻辑：TaskListener 中可以执行业务逻辑，例如根据任务的状态和条件执行不同的操作，对任务进行分类、路由等处理。
 * 增强流程的可维护性和可扩展性：通过使用 TaskListener，可以将任务相关的业务逻辑封装在独立的组件中，使得流程定义更加清晰和易于维护。同时，通过编写自定义的 TaskListener，可以根据实际需求扩展流程的功能和行为。
 *
 * @author zhihao.mao
 */

public interface ITaskListener extends TaskListener {
}
