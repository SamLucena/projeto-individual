package app.vercel.samlucena.game.resources;

import app.vercel.samlucena.game.dto.UserDTO;
import app.vercel.samlucena.game.dto.UserSaveDTO;
import app.vercel.samlucena.game.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;
    @PostMapping
    public  ResponseEntity<UserDTO> save(@Valid @RequestBody UserSaveDTO dto){
        UserDTO user = service.save(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand().toUri();
        return ResponseEntity.created(uri).body(user);
    }

}
