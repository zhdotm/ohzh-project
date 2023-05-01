package io.github.zhdotm.ohzh.extension.core;

import io.github.zhdotm.ohzh.biz.dto.BizScenario;
import io.github.zhdotm.ohzh.extension.core.executor.IExtensionExecutor;
import io.github.zhdotm.ohzh.extension.core.executor.impl.ExtensionExecutor;
import io.github.zhdotm.ohzh.extension.core.point.IPointA;
import io.github.zhdotm.ohzh.extension.core.point.IPointB;
import io.github.zhdotm.ohzh.extension.core.scanner.IExtensionScanner;
import io.github.zhdotm.ohzh.extension.core.scanner.impl.ExtensionScanner;

/**
 * @author zhihao.mao
 */

public class AppTest {

    public static void main(String[] args) {
        IExtensionScanner extensionScanner = ExtensionScanner.getInstance();
        extensionScanner.scanExtensions("io.github.zhdotm.ohzh.extension.core");
        IExtensionExecutor extensionExecutor = ExtensionExecutor.getInstance();
        extensionExecutor.execute(BizScenario.newDefault(), IPointA.class, IPointA::methodA);
        String defaultResult = extensionExecutor.execute(BizScenario.newDefault(), IPointB.class, IPointB::methodB);
        String jiaResult = extensionExecutor.execute(BizScenario.valueOf("bizId", "useCase", "scenarioJia"), IPointB.class, IPointB::methodB);
        System.out.println(defaultResult);
        System.out.println(jiaResult);
    }

}
