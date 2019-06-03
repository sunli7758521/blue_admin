package com.ruoyi.integral.domain;

import java.io.Serializable;

public class MenuDepts implements Serializable {

    /** 积分项关联部门id */
    private Long menuDeptId;
    /** 积分项id */
    private Long menuId;
    /** 部门id */
    private Long deptId;
    /** 积分项名称 */
    private String menuName;
    /** 积分项关联部门名称 */
    private String deptName;

    public Long getMenuDeptId() {
        return menuDeptId;
    }

    public void setMenuDeptId(Long menuDeptId) {
        this.menuDeptId = menuDeptId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
