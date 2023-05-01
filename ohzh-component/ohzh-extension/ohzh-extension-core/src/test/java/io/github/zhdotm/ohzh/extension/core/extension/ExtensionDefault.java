package io.github.zhdotm.ohzh.extension.core.extension;

import io.github.zhdotm.ohzh.extension.core.IExtension;
import io.github.zhdotm.ohzh.extension.core.annotation.Extension;
import io.github.zhdotm.ohzh.extension.core.point.IPointA;
import io.github.zhdotm.ohzh.extension.core.point.IPointB;
import io.github.zhdotm.ohzh.extension.core.point.IPointC;

/**
 * 默认拓展
 *
 * @author zhihao.mao
 */

@Extension(
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
public class ExtensionDefault implements IExtension, IPointA, IPointB, IPointC {

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
