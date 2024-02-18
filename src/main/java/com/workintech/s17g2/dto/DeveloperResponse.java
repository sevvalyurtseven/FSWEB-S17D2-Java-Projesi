package com.workintech.s17g2.dto;

import com.workintech.s17g2.model.Experience;

public record DeveloperResponse(String message, Integer id, String name, Double salary, Experience experience) {
}
