package dev.joaop.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AlreadyExistsException extends RuntimeException {
    final String origin, item;

    @Override
    public String getMessage() {
        return "The " + item + " already exists in " + origin;
    }
}
