package com.example.demo.vo;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginVO {

    private String accessToken;

    private UserVO userVO;

}
