package app.vercel.samlucena.game.resources;

import app.vercel.samlucena.game.dto.GameReviewDTO;
import app.vercel.samlucena.game.services.GameReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/reviews")
public class GameReviewResource {

    @Autowired
    private GameReviewService service;

    @GetMapping
    public ResponseEntity<Page<GameReviewDTO>> findAll(Pageable pageable){
        Page<GameReviewDTO> page = service.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @PostMapping
    public  ResponseEntity<GameReviewDTO> save(@Valid @RequestBody GameReviewDTO review){
        review = service.save(review);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
        return ResponseEntity.created(uri).body(review);
    }

}
