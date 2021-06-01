package org.babareko.graduationBoot.repository;

import org.babareko.graduationBoot.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote, Integer> {
}
