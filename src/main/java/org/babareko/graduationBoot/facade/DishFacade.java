package org.babareko.graduationBoot.facade;

import org.babareko.graduationBoot.model.Dish;
import org.babareko.graduationBoot.to.DishTo;
import org.springframework.stereotype.Component;

@Component
public class DishFacade {

    public DishTo dishToDishTO(Dish dish){
        DishTo dishTo = new DishTo();
        dishTo.setId(dish.getId());
        dishTo.setName(dish.getName());
        dishTo.setPrice(dish.getPrice());
        return dishTo;
    }
}
