package org.babareko.graduationBoot.repository;

import org.babareko.graduationBoot.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}
