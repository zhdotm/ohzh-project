package io.github.zhdotm.ohzh.extension.starter.web.extension;

import io.github.zhdotm.ohzh.extension.core.annotation.Extension;
import io.github.zhdotm.ohzh.extension.starter.web.annotation.SpringExtension;
import io.github.zhdotm.ohzh.extension.starter.web.point.IPointA;
import io.github.zhdotm.ohzh.extension.starter.web.point.IPointB;
import io.github.zhdotm.ohzh.extension.starter.web.point.IPointC;

/**
 * 拓展甲
 *
 * @author zhihao.mao
 */

@SpringExtension(
        name = "拓展甲",
        code = "extensionJia",
        points = {
                @Extension.ExtensionPoint(
                        targetClazz = IPointA.class,
                        bizId = "bizId",
                        useCase = "useCase",
                        scenario = "scenarioJia"
                ),
                @Extension.ExtensionPoint(
                        targetClazz = IPointB.class,
                        bizId = "bizId",
                        useCase = "useCase",
                        scenario = "scenarioJia"
                ),
                @Extension.ExtensionPoint(
                        targetClazz = IPointC.class,
                        bizId = "bizId",
                        useCase = "useCase",
                        scenario = "scenarioJia"
                ),
        }
)
public class ExtensionJia implements ISpringExtension, IPointA, IPointB, IPointC {

    @Override
    public void methodA() {
        System.out.println("进入拓展甲的拓展点A");
    }

    @Override
    public String methodB() {
        System.out.println("进入拓展甲的拓展点B");

        return "拓展甲的拓展点B的返回值";
    }

    @Override
    public void methodC() {
        System.out.println("进入拓展甲的拓展点C");
    }

}
