package com.example.socket.domain.user.controller.dto.response;

import com.example.socket.domain.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MyPageResponse {

    private Long id;

    public MyPageResponse(User user) {
        id = user.getId();
    }

}
