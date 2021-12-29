package com.pocoda.user.model.request;

import com.pocoda.user.model.City;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@Value
@Builder
@RequiredArgsConstructor
public class UpdateCityRequest {
    private Long userId;
    private City city;
}
