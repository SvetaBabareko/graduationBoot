package org.babareko.graduationBoot.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.babareko.graduationBoot.model.Dish;
import org.babareko.graduationBoot.model.Restaurant;
import org.babareko.graduationBoot.repository.DishRepository;
import org.babareko.graduationBoot.repository.RestaurantRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(RestaurantRestController.URL)
@AllArgsConstructor
@Slf4j
public class DishRestController {
    static final String URL = "/api/restaurants/{id}/dishes";

    private final DishRepository dishRepository;

    @GetMapping
    public List<Dish> getAll(@PathVariable Integer restaurantId) {
        log.info("get all dishes for restaurant {}", restaurantId);
        return dishRepository.findAllByRestaurant(restaurantId);
    }
}
