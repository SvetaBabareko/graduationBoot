package org.babareko.graduationBoot.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="restaurants")
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant extends AbstractEntity{
    @NotBlank
    @Column(name = "name", nullable = false)
    @Size(min = 1, max = 100)
    private String name;

    @NotBlank
    @Column(name = "description", nullable = false)
    @Size(min = 1, max = 250)
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


}
