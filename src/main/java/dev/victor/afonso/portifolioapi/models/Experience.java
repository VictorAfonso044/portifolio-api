package dev.victor.afonso.portifolioapi.models;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "experience")
public class Experience {

    private ObjectId id;
    private String name;
    private String description;
    private Date initialDate;
    private Date endDate;

}