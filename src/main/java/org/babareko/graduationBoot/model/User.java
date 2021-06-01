package org.babareko.graduationBoot.model;

import lombok.*;


import java.util.Date;


@Data
@Setter
@Getter
@ToString(callSuper = true, exclude = {"password"})
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractEntity {
    private String name;
    private String password;
    private boolean enabled = true;
    private Date registered = new Date();

}
