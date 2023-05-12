package app.vercel.samlucena.game.services;

import app.vercel.samlucena.game.dto.GameReviewDTO;
import app.vercel.samlucena.game.dto.PlatformDTO;
import app.vercel.samlucena.game.entities.Platform;
import app.vercel.samlucena.game.repositories.PlatformRepository;
import app.vercel.samlucena.game.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service
public class PlatformService implements Serializable {

    @Autowired
    private PlatformRepository repository;

    @Transactional(readOnly = true)
    public Page<PlatformDTO> findAll(Pageable pageable){
        Page<PlatformDTO> page = repository.findAll(pageable).map(x -> new PlatformDTO(x, x.getReviews()));
        return page;
    }

    @Transactional(readOnly = true)
    public PlatformDTO findById(Long id) {
        Platform entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        return new PlatformDTO(entity, entity.getReviews());
    }

}
