package org.babareko.graduationBoot.repository;

import org.babareko.graduationBoot.model.Dish;
import org.babareko.graduationBoot.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface DishRepository extends JpaRepository<Dish, Integer> {

    @Query(value = "SELECT d FROM Dish d where d.restaurant=?1")
    List<Dish> findAllByRestaurant(Restaurant id);

}

