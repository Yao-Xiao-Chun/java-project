package com.company.project.model.entity;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Area {

    /**
     * 地区自增ID
     */
    private Long area_id;

    /**
     * 地区名称
     */
    private String area_name;

    /**
     * 地区上级ID
     */
    private Long area_parent_id;

    /**
     * 地区排序
     */
    private Integer area_sort;

    /**
     * 地区深度
     */
    private Integer area_deep;

    /**
     * 大区名称
     */
    private String area_region;

    /**
     *
     * @return
     */
    public Long getArea_id() {
        return area_id;
    }

    /**
     *
     * @param area_id
     */
    public void setArea_id(Long area_id) {
        this.area_id = area_id;
    }

    /**
     *
     * @return
     */
    public String getArea_name() {
        return area_name;
    }

    public void setArea_name(String area_name) {
        this.area_name = area_name;
    }

    public Long getArea_parent_id() {
        return area_parent_id;
    }

    public void setArea_parent_id(Long area_parent_id) {
        this.area_parent_id = area_parent_id;
    }

    public Integer getArea_sort() {
        return area_sort;
    }

    public void setArea_sort(Integer area_sort) {
        this.area_sort = area_sort;
    }

    public Integer getArea_deep() {
        return area_deep;
    }

    public void setArea_deep(Integer area_deep) {
        this.area_deep = area_deep;
    }

    public String getArea_region() {
        return area_region;
    }

    public void setArea_region(String area_region) {
        this.area_region = area_region;
    }
}
