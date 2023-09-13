package com.example.cmd.domain.user.controller.dto.response;

import com.example.cmd.domain.user.domain.User;
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
