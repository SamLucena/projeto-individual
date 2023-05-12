package app.vercel.samlucena.game.resources;

import app.vercel.samlucena.game.dto.PlatformDTO;
import app.vercel.samlucena.game.services.PlatformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/platforms")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlatformResource {

    @Autowired
    private PlatformService service;

    @GetMapping
    public ResponseEntity<Page<PlatformDTO>> findAll(Pageable pageable){
        Page<PlatformDTO> page = service.findAll(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlatformDTO> findById(@PathVariable Long id){
        PlatformDTO dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

}
