package com.chunsik.sample.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class Sample {
    private String name;
    private String email;

}
