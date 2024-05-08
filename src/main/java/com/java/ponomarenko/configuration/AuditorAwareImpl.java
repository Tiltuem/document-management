package com.java.ponomarenko.configuration;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        //TODO Вернуть имя создателя
        return Optional.of("ZZZ");
    }
}
