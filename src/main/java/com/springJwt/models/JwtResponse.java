package com.springJwt.models;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class JwtResponse {
    private String jwtToken;

    private String username;
}
