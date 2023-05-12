package app.vercel.samlucena.game.repositories;

import app.vercel.samlucena.game.entities.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {

}
