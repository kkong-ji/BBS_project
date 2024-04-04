package com.example.BBS.domain.user;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long userId;             // 유저 아이디
    private String userName;         // 유저 이름
    private String userEmail;        // 유저 이메일
    private String userPassword;     // 유저 비밀번호
    private Integer userAge;         // 유저 나이

    @Builder
    public UserDto(Long userId, String userName, String userEmail) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }
}
