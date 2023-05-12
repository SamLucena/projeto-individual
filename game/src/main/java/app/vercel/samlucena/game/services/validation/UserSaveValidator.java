package app.vercel.samlucena.game.services.validation;

import app.vercel.samlucena.game.dto.UserSaveDTO;
import app.vercel.samlucena.game.entities.User;
import app.vercel.samlucena.game.repositories.UserRepository;
import app.vercel.samlucena.game.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class UserSaveValidator implements ConstraintValidator<UserSaveValid, UserSaveDTO> {

    @Autowired
    private UserRepository repository;

    @Override
    public void initialize(UserSaveValid ann) {
    }

    @Override
    public boolean isValid(UserSaveDTO dto, ConstraintValidatorContext context) {

        List<FieldMessage> list = new ArrayList<>();
        User user = repository.findByEmail(dto.getEmail());
        if(user != null){
            list.add(new FieldMessage("email", "E-mail já existe"));
        }

        for (FieldMessage e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
