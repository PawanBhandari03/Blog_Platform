package com.pawan.blog.Services;

import com.pawan.blog.domain.entities.User;

import java.util.UUID;

public interface UserService {
    User getUserById(UUID id);
}
