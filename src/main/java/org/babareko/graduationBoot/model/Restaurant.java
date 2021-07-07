package org.babareko.graduationBoot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="restaurants")
@Setter
@Getter
@ToString
@NoArgsConstructor
//@AllArgsConstructor
public class Restaurant extends AbstractEntity{
    @NotBlank
    @Column(name = "name", nullable = false)
    @Size(min = 1, max = 100)
    private String name;

    @NotBlank
    @Column(name = "description", nullable = false)
    @Size(min = 1, max = 250)
    private String description;

    public Restaurant(int id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

   // @OneToMany(fetch = FetchType.LAZY, mappedBy = "restaurant")
          //  cascade = CascadeType.ALL)
    //@JsonIgnore
    //@JsonBackReference
   // private List<Dish> dishes;

    public Restaurant(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
