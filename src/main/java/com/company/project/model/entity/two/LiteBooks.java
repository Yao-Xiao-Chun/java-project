package com.company.project.model.entity.two;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class LiteBooks {

    /**
     * 主键id
     */
    public Long id;

    /**
     * 文章名称
     */
    public String name;


    /**
     * 图片地址
     */
    public String image;


    /**
     * 文章链接
     */
    public String url;
}
