package app.vercel.samlucena.game.repositories;

import app.vercel.samlucena.game.entities.GameReview;
import app.vercel.samlucena.game.entities.Platform;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GameReviewRepository extends JpaRepository<GameReview, Long> {

    @Query("SELECT obj FROM GameReview obj WHERE obj.platform = :platform")
    Page<GameReview> findAllByPlatform(Platform platform, Pageable pageable);
}
