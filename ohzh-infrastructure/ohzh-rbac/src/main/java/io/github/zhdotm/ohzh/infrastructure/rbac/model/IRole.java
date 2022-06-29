package io.github.zhdotm.ohzh.infrastructure.rbac.model;

import java.util.List;

/**
 * 角色
 *
 * @author zhihao.mao
 */
public interface IRole {

    /**
     * 获取角色ID
     *
     * @return 角色ID
     */
    String id();

    /**
     * 获取上级角色
     *
     * @return 上级角色
     */
    IRole getParent();

    /**
     * 获取角色权限
     *
     * @return 角色权限
     */
    List<IPermission> getPermissions();
}
