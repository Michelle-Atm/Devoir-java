package com.michelle.project.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;


public record UserRequest(
        @NotBlank(message = "le nom est required")
        String username,
        @NotBlank(message = "l'email est required") @Email(message = "entrer un email au format valide")
        String email,
        @NotBlank(message = "le mot de passe est required")
        String password,
        @NotBlank(message = "otp is required..")
        String otp,
        @NotBlank(message = "le numéro de téléphone est required")
        @Pattern(regexp = "\\+237[0-9]+", message = "Le numéro doit commencé par +237 et ne contenir que des chiffres")
        String phoneNumber) {
}
