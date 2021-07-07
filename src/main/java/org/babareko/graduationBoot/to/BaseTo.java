package org.babareko.graduationBoot.to;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class BaseTo {
    protected Integer id;


    @JsonIgnore
    public boolean isNew() {
        return id == null;
    }
}
