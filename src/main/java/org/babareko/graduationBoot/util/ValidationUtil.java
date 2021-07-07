package org.babareko.graduationBoot.util;

import lombok.experimental.UtilityClass;
import org.babareko.graduationBoot.model.AbstractEntity;
import org.babareko.graduationBoot.to.BaseTo;
import org.babareko.graduationBoot.util.exception.IllegalRequestDataException;

@UtilityClass
public class ValidationUtil {
    public static void checkNew(AbstractEntity entity) {
        if (!entity.isNew()) {
            throw new IllegalRequestDataException(entity.getClass().getSimpleName() + " must be new (id=null)");
        }
    }

    //  Conservative when you reply, but accept liberally (http://stackoverflow.com/a/32728226/548473)
    public static void assureIdConsistent(BaseTo entity, int id) {
        if (entity.isNew()) {
            entity.setId(id);
        } else if (entity.getId() != id) {
            throw new IllegalRequestDataException(entity.getClass().getSimpleName() + " must has id=" + id);
        }
    }
}
