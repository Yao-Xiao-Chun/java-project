package com.company.project.model.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;


@Data
@Document(indexName = "book",type = "book_info",createIndex = false)
public class Book {
    @Id
    private String id;

    private String bookName;
}
