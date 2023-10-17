package com.springJwt.models;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class JwtRequest {

    private String email;

    private String password;
}
