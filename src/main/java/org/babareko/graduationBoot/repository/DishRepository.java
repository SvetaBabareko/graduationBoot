package org.babareko.graduationBoot.repository;

import org.babareko.graduationBoot.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Integer> {
}

