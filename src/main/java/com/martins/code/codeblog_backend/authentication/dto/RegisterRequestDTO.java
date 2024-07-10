package com.martins.code.codeblog_backend.authentication.dto;

public record RegisterRequestDTO (String name, String username, String email, String password) {
}
