package app.vercel.samlucena.game.services;

import app.vercel.samlucena.game.dto.GameReviewDTO;
import app.vercel.samlucena.game.entities.GameReview;
import app.vercel.samlucena.game.entities.Platform;
import app.vercel.samlucena.game.entities.User;
import app.vercel.samlucena.game.repositories.GameReviewRepository;
import app.vercel.samlucena.game.repositories.PlatformRepository;
import app.vercel.samlucena.game.repositories.UserRepository;
import app.vercel.samlucena.game.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class GameReviewService {

    @Autowired
    private GameReviewRepository repository;

    @Autowired
    private PlatformRepository platformRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public Page<GameReviewDTO> findAll(Long platformId, Pageable pageable){
        if(platformId != null){
            Platform platform = platformRepository.findById(platformId).orElseThrow(() -> new ResourceNotFoundException("Platform not found"));
            Page<GameReview> page = repository.findByPlatform(platform, pageable);
            return page.map(GameReviewDTO::new);
        }
        Page<GameReview> page = repository.findAll(pageable);
        return page.map(GameReviewDTO::new);

    }


    @Transactional
    public GameReviewDTO save(GameReviewDTO review){
        GameReview entity = new GameReview();
        copyDtoToEntity(review, entity);
        entity = repository.save(entity);
        return new GameReviewDTO(entity);
    }

    private void copyDtoToEntity(GameReviewDTO dto, GameReview entity){
        User user = userRepository.findByEmail(userDetailsService.loadUserByUsername(dto.getAuthor().getEmail()).getUsername());
        entity.setAuthor(user);
        entity.setComment(dto.getComment());
        dto.setMoment(entity.getMoment());
        entity.setScore(dto.getScore());
        entity.setTitle(dto.getTitle());
        Platform platform = platformRepository.findById(dto.getPlatform().getId()).orElseThrow(() -> new ResourceNotFoundException("Platform not found"));
        entity.setPlatform(platform);
    }
}
