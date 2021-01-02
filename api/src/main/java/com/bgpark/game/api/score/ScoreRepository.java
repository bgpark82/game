package com.bgpark.game.api.score;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Long> {

    @Query("SELECT SUM(s.score) " +
            "FROM Score s " +
            "WHERE s.username = :username " +
            "GROUP BY s.username")
    int getTotalScoreByUsername(@Param("username") String username);

    List<Score> findAllByUsername(String bgpark);
}
