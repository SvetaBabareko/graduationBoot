package org.babareko.graduationBoot.model;

import lombok.*;

@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Dish extends AbstractEntity{
    private String name;
    private Double price;
    private Restaurant restaurant;
}
