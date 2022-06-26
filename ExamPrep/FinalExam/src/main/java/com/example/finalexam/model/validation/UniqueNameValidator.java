package com.example.finalexam.model.validation;

import com.example.finalexam.service.SongService;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueNameValidator implements ConstraintValidator<UniqueName, String> {

    private final SongService songService;

    public UniqueNameValidator(SongService songService) {
        this.songService = songService;
    }

    @Override
    public boolean isValid(String performer, ConstraintValidatorContext context) {
        if (performer == null) {
            return true;
        }
        return songService.isFreeName(performer);
    }
}
