package com.nca.project.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String imagePath;
    private int price;

    @Override
    public String toString(){
        return "id: " + id + ", name: " + name + ", description: "
                + description + ", image path: " + imagePath + ", price" + price;
    }
}
