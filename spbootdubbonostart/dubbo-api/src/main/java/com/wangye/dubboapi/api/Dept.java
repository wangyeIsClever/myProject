package com.wangye.dubboapi.api;

import java.util.List;

public class Dept {

    /**
     * 部门
     */
    private Long id;
    private String name;
    private Long parentId;
    private Boolean hasSub;

    private List<Dept> subDeptList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Boolean getHasSub() {
        return hasSub;
    }

    public void setHasSub(Boolean hasSub) {
        this.hasSub = hasSub;
    }

    public List<Dept> getSubDeptList() {
        return subDeptList;
    }

    public void setSubDeptList(List<Dept> subDeptList) {
        this.subDeptList = subDeptList;
    }

    public Dept(Long id, String name, Long parentId, Boolean hasSub) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.hasSub = hasSub;
    }
}
