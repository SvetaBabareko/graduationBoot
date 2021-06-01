package org.babareko.graduationBoot.model;

import lombok.*;

@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant extends AbstractEntity{
    private String name;
    private String description;
}
