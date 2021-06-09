package org.babareko.graduationBoot.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.babareko.graduationBoot.model.Restaurant;
import org.babareko.graduationBoot.repository.RestaurantRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(RestaurantRestController.URL)
@AllArgsConstructor
@Slf4j
public class RestaurantRestController {
    static final String URL = "/api/restaurants";

    private final RestaurantRepository restaurantRepository;

    @GetMapping
    public List<Restaurant> getAll() {
        log.info("get all restaurants");
        return restaurantRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Restaurant> get(@PathVariable Integer id) {
        log.info("get restaurant {}", id);
        return restaurantRepository.findById(id);
    }

}
