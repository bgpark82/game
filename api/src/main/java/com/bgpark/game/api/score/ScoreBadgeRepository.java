package com.bgpark.game.api.score;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ScoreBadgeRepository extends JpaRepository<ScoreBadge, Long> {

    @Query("select s from ScoreBadge s where s.username = :username order by s.timestamp desc")
    Page<ScoreBadge> findTopScore(@Param("username") String username, Pageable pageable);

    ScoreBadge findFirstByUsernameOrderByTimestampDesc(String username);
}
