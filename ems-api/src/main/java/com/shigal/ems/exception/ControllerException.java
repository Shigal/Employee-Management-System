package com.shigal.ems.exception;/*
 *
 * @author Lawshiga
 *
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ControllerException extends RuntimeException{

    private static final long serialVersionUID = 8709360106183142224L;
    private String errorCode;
    private String errorMessage;
}
