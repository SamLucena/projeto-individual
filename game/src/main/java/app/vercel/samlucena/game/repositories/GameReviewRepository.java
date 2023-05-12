package app.vercel.samlucena.game.repositories;

import app.vercel.samlucena.game.entities.GameReview;
import app.vercel.samlucena.game.entities.Platform;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameReviewRepository extends JpaRepository<GameReview, Long> {

    Page<GameReview> findByPlatform(Platform platform, Pageable pageable);
}
