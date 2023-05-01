package io.github.zhdotm.ohzh.extension.starter.web.extension;

import io.github.zhdotm.ohzh.extension.core.annotation.Extension;
import io.github.zhdotm.ohzh.extension.starter.web.annotation.SpringExtension;
import io.github.zhdotm.ohzh.extension.starter.web.point.IPointA;
import io.github.zhdotm.ohzh.extension.starter.web.point.IPointB;
import io.github.zhdotm.ohzh.extension.starter.web.point.IPointC;

/**
 * 默认拓展
 *
 * @author zhihao.mao
 */

@SpringExtension(
        name = "默认拓展",
        code = "extensionDefault",
        points = {
                @Extension.ExtensionPoint(
                        targetClazz = IPointA.class
                ),
                @Extension.ExtensionPoint(
                        targetClazz = IPointB.class
                ),
                @Extension.ExtensionPoint(
                        targetClazz = IPointC.class
                ),
        }
)
public class ExtensionDefault implements ISpringExtension, IPointA, IPointB, IPointC {

    @Override
    public void methodA() {
        System.out.println("进入默认拓展的拓展点A");
    }

    @Override
    public String methodB() {
        System.out.println("进入默认拓展的拓展点B");

        return "默认拓展的拓展点B的返回值";
    }

    @Override
    public void methodC() {
        System.out.println("进入默认拓展的拓展点C");
    }

}
