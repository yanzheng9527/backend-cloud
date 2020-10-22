package com.randy.backend.model;

public class Resource extends Entity {
    private String name;
    private String type;
    private String resouceLevelName;
    private String parentId;
    private Integer sort;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResouceLevelName() {
        return resouceLevelName;
    }

    public void setResouceLevelName(String resouceLevelName) {
        this.resouceLevelName = resouceLevelName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
