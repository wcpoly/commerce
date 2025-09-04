package com.gtalent.commerce.admin.mappers;

import com.gtalent.commerce.admin.dtos.UserRequest;
import com.gtalent.commerce.admin.dtos.UserResponse;
import com.gtalent.commerce.admin.dtos.UserSegmentResponse;
import com.gtalent.commerce.admin.models.User;
import com.gtalent.commerce.admin.models.UserSegment;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {

    public UserResponse toUserResponse(User user) {
        UserResponse dto = new UserResponse();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmail(user.getEmail());
        dto.setBirthday(user.getBirthday());
        dto.setAddress(user.getAddress());
        dto.setCity(user.getCity());
        dto.setZipcode(user.getZipcode());
        dto.setRole(user.getRole());
        dto.setHasNewsletter(user.isHasNewsletter());
        dto.setLastSeenAt(user.getLastSeenAt());
        dto.setCreatedAt(user.getCreatedAt());
        dto.setDeletedAt(user.getDeletedAt());
        if (user.getUserSegments() != null) {
            dto.setUserSegments(user.getUserSegments().stream()
                    .map(this::toUserSegmentResponse)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public User toUser(UserRequest dto) {
        User user = new User();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmail(dto.getEmail());
        user.setBirthday(dto.getBirthday());
        user.setAddress(dto.getAddress());
        user.setCity(dto.getCity());
        user.setZipcode(dto.getZipcode());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setHasNewsletter(dto.isHasNewsletter());
        return user;
    }

    public UserSegmentResponse toUserSegmentResponse(UserSegment userSegment) {
        UserSegmentResponse dto = new UserSegmentResponse();
        dto.setId(userSegment.getId());
        dto.setUserId(userSegment.getUser().getId());
        dto.setSegmentId(userSegment.getSegment().getId());
        return dto;
    }
}

