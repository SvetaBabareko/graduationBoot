package org.babareko.graduationBoot.repository;


import org.babareko.graduationBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepository extends JpaRepository<User, Integer> {

   /* @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
    int deleteById(@Param("id") int id);

   //    https://stackoverflow.com/a/46013654/548473
    @EntityGraph(attributePaths = {"votes"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT u FROM User u WHERE u.id=?1")
    User getWithVotes(int id);*/

    Optional<User> findById(int id);


    Optional<User> findByName(String name);


}
