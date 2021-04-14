package com.company.project.model.entity.two;

import lombok.Data;

import javax.persistence.Entity;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
public class LiteBooks {

    /**
     * 主键id
     */
    public Integer id;

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

    /**
     * 创建时间
     */
    public Date created_at;

    /**
     * 更新时间
     */
    public Date updated_at;

    /**
     * 删除时间
     */
    public Date deleted_at;
}
