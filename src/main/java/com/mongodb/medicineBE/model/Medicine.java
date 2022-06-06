package com.mongodb.medicineBE.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Setter
@Getter
@ToString
@Document(collection="medicine")
public class Medicine {
    @Id
    private int id;
    private String name;
    private String price;
}
