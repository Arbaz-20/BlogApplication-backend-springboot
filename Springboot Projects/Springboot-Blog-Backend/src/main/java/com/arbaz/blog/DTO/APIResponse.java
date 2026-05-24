package com.arbaz.blog.DTO;

import lombok.*;
import org.springframework.http.HttpStatus;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class APIResponse {

    @NotNull
    private String message;
    private boolean success = true;

}
