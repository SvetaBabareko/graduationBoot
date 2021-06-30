package org.babareko.graduationBoot.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.babareko.graduationBoot.model.Dish;
import org.babareko.graduationBoot.model.Restaurant;
import org.babareko.graduationBoot.repository.DishRepository;
import org.babareko.graduationBoot.repository.RestaurantRepository;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(DishRestController.URL)
@AllArgsConstructor
@Slf4j
public class DishRestController {
    static final String URL = "/api/dishes";

    private final DishRepository dishRepository;
    private final RestaurantRepository restaurantRepository;

   @GetMapping
   public List<Dish> getAll() {
       log.info("get all dishes {}");
       return dishRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Dish> get(@PathVariable Integer id) {
        log.info("get dish {}", id);
        return dishRepository.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Dish> create(@Valid @RequestBody Dish dish) {
       // log.info("create dish {} for the restaurant {}", dish, restaurantId);
        //dish.setRestaurant(restaurantRepository.getById(restaurantId));
        Dish created = dishRepository.save(dish);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }


}
