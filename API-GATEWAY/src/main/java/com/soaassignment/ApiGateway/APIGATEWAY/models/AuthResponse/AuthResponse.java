package com.soaassignment.ApiGateway.APIGATEWAY.models.AuthResponse;

import lombok.*;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuthResponse {
    private String userId;
    private String accessToken;
    private String refreshToken;
    private long expireAt;

    private Collection<String> authorities;
}
