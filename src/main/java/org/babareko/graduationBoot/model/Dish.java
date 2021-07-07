package org.babareko.graduationBoot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dishes")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Dish extends AbstractEntity{
    @Column(name = "name", nullable = false)
    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

    @Column(name = "price", nullable = false)
    @NotNull
    @Range(min = 0, max = 10000)
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonBackReference
    @JsonIgnore
    //@JsonManagedReference
    //@NotNull
    private Restaurant restaurant;


    public Dish(int id, String name, double price) {
        super(id);
        this.name = name;
        this.price = price;
    }

    public Dish(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
