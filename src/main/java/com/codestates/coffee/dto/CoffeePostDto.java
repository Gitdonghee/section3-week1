package com.codestates.coffee.dto;

import lombok.Getter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Pattern;

@Getter
public class CoffeePostDto {
    @Pattern(regexp = "^[가-힣]+$", message = "한글만 작성가능합니다.(띄어쓰기 x)")
    private String korName;
    @Pattern(regexp = "^[a-zA-Z]+(?: [a-zA-Z]+)*$", message = "영문으로 작성하셔야 하며 공백은 띄어쓰기만 가능합니다.")
    private String engName;
    @Range(min = 500, max = 50000)
    private int price;

    @Pattern(regexp = "^[a-zA-Z]{3}$",message = "3자리 영문으로 입력하세요.")
    private String coffeeCode;
}
