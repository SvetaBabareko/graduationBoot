package org.babareko.graduationBoot.repository;

import org.babareko.graduationBoot.model.Restaurant;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    //    https://stackoverflow.com/a/46013654/548473
    @EntityGraph(attributePaths = {"dishes"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT r FROM Restaurant r WHERE r.id=?1")
    Restaurant  findAllWithDishes(@Param("id")Integer id);

   // @Query("SELECT r FROM Restaurant r")
   // List<Restaurant> getAll();

    //@Query("SELECT r FROM Restaurant r where r.id=?1")
   // Optional<Restaurant> findById(Integer id);

}
