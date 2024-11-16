package com.debkanta.projects.NewsAggregatorAPI.model;

import com.debkanta.projects.NewsAggregatorAPI.entity.AuthUser;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class RegistrationResponseModel {
    private AuthUser user;
    private String applicationUrl;
}
