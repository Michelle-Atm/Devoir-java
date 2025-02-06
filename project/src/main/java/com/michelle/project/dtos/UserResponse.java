package com.michelle.project.dtos;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;


@Builder
public record UserResponse (
    @NotNull
    String username,

    @NotBlank(message = "l'zmail doit être inclus dans la réponse.")
    String email,

    @NotBlank(message = "le numéro de téléphone doit être inclus dans la réponse....")
    String phone) {

}
