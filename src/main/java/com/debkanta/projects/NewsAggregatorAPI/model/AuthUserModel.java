package com.debkanta.projects.NewsAggregatorAPI.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AuthUserModel {
    private String userName;
    private String password;
    private String email;
}
