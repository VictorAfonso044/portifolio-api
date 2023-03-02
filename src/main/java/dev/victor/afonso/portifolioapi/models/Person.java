package dev.victor.afonso.portifolioapi.models;

import java.util.Date;
import java.util.List;

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
@Document(collection = "person")
public class Person {

    private ObjectId id;
    private String name;
    private String nickname;
    private String state;
    private String city;
    private Date birthday;
    private List<String> experiencesIds;
}