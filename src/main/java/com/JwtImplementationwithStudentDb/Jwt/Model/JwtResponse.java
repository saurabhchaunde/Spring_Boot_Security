package com.JwtImplementationwithStudentDb.Jwt.Model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class JwtResponse {
    private String username;
    private String JwtToken;
}
