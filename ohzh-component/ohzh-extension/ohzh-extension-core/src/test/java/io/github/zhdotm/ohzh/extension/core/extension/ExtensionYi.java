package io.github.zhdotm.ohzh.extension.core.extension;

import io.github.zhdotm.ohzh.extension.core.IExtension;
import io.github.zhdotm.ohzh.extension.core.annotation.Extension;
import io.github.zhdotm.ohzh.extension.core.point.IPointA;
import io.github.zhdotm.ohzh.extension.core.point.IPointB;
import io.github.zhdotm.ohzh.extension.core.point.IPointC;

/**
 * 拓展乙
 *
 * @author zhihao.mao
 */

@Extension(
        name = "拓展乙",
        code = "extensionYi",
        points = {
                @Extension.ExtensionPoint(
                        targetClazz = IPointA.class,
                        bizId = "bizId",
                        useCase = "useCase",
                        scenario = "scenarioYi"
                ),
                @Extension.ExtensionPoint(
                        targetClazz = IPointB.class,
                        bizId = "bizId",
                        useCase = "useCase",
                        scenario = "scenarioYi"
                ),
                @Extension.ExtensionPoint(
                        targetClazz = IPointC.class,
                        bizId = "bizId",
                        useCase = "useCase",
                        scenario = "scenarioYi"
                ),
        }
)
public class ExtensionYi implements IExtension, IPointA, IPointB, IPointC {

    @Override
    public void methodA() {
        System.out.println("进入拓展乙的拓展点A");
    }

    @Override
    public String methodB() {
        System.out.println("进入拓展乙的拓展点B");

        return "拓展乙的拓展点B的返回值";
    }

    @Override
    public void methodC() {
        System.out.println("进入拓展乙的拓展点C");
    }

}
