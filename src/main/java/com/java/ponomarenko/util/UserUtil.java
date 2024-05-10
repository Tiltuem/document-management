package com.java.ponomarenko.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class UserUtil {
    private static final Map<String, String> usernameHisCity = Map.of("dirSamara", "Самара", "dirMoscow", "Москва", "dirStPeter", "Санкт-Петербург", "admin", "all");

    public static String getCity() {
        return usernameHisCity.get(SecurityContextHolder.getContext().getAuthentication().getName());
    }
}
