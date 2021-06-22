package org.babareko.graduationBoot.to;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class DishTo extends BaseTo implements Serializable {

    @NotBlank
    @Size(min = 1, max = 100)
    private String name;

    @NotNull
    @Range(min = 0, max = 10000)
    private Double price;
}
