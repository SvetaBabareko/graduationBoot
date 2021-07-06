package org.babareko.graduationBoot.to;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@Data
public class UserTo extends BaseTo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotBlank
    @Size(min = 2, max = 100)
    //@SafeHtml
    private String name;

    @NotBlank
    @Size(min = 5, max = 32)
    private String password;

    public UserTo(Integer id, @NotBlank @Size(min = 2, max = 100) String name, @NotBlank @Size(min = 5, max = 32) String password) {
        super(id);
        this.name = name;
        this.password = password;
    }

}
