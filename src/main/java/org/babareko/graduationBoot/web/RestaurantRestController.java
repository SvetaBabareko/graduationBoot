package org.babareko.graduationBoot.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.babareko.graduationBoot.model.Restaurant;
import org.babareko.graduationBoot.repository.RestaurantRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.net.URI;
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Restaurant> create(@Valid @RequestBody Restaurant restaurant) {
        log.info("create restaurant {}", restaurant);
        Restaurant created = restaurantRepository.save(restaurant);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(URL + "/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(created);
    }


    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Restaurant update(@PathVariable(value = "id") Integer id,
                         @Valid @RequestBody Restaurant restaurantNew) throws EntityNotFoundException {
        log.info("update restaurant {}: {}", id, restaurantNew);
        Restaurant restaurant = restaurantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException());
        restaurant.setName(restaurantNew.getName());
        restaurant.setDescription(restaurantNew.getDescription());
        return restaurantRepository.save(restaurant);
    }



}
