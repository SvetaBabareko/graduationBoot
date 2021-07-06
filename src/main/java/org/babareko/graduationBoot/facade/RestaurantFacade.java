package org.babareko.graduationBoot.facade;

import org.babareko.graduationBoot.model.Restaurant;
import org.babareko.graduationBoot.to.RestaurantTo;
import org.springframework.stereotype.Component;

@Component
public class RestaurantFacade {

    public RestaurantTo restaurantToRestaurantTO(Restaurant restaurant){
        RestaurantTo restaurantTo = new RestaurantTo();
        restaurantTo.setId(restaurant.getId());
        restaurantTo.setName(restaurant.getName());
        restaurantTo.setDescription(restaurant.getDescription());

        return restaurantTo;
    }
}
