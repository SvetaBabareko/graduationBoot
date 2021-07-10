package org.babareko.graduationBoot.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.babareko.graduationBoot.model.Dish;
import org.babareko.graduationBoot.model.Restaurant;
import org.babareko.graduationBoot.repository.DishRepository;
import org.babareko.graduationBoot.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
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
   // @PreAuthorize("hasRole('ADMIN')")
    public List<Dish> getAll() {
        log.info("get all dishes");
        return dishRepository.findAll();
    }

    @GetMapping(value = "/restaurant/{restaurantId}")
    public List<Dish> getAllForRestaurant(@PathVariable int restaurantId) {
        log.info("get dishes for restaurant id {}", restaurantId);
        Restaurant restaurant = restaurantRepository.getById(restaurantId);
        return dishRepository.findAllByRestaurant(restaurant);
    }

    @GetMapping("/{id}")
    public Optional<Dish> get(@PathVariable Integer id) {
        log.info("get dish {}", id);
        return dishRepository.findById(id);
    }

    @PostMapping(value = "/{restaurantId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Dish> create(@Valid @RequestBody Dish dish, @PathVariable int restaurantId) {
        log.info("create dish {} for the restaurant {}", dish, restaurantId);
        dish.setRestaurant(restaurantRepository.getById(restaurantId));
        Dish created = dishRepository.save(dish);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(URL + "dishes/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Dish update(@PathVariable(value = "id") Integer id,
                             @Valid @RequestBody Dish dish) throws EntityNotFoundException {
        log.info("update dish {}", dish);
        Dish dishUpdate = dishRepository.getById(dish.getId());
        dishUpdate.setName(dish.getName());
        dishUpdate.setPrice(dish.getPrice());
        return dishRepository.save(dishUpdate);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(@PathVariable int id) throws EntityNotFoundException {
        log.info("delete dish {}", id);
        Dish dish = dishRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        dishRepository.delete(dish);
    }




}
