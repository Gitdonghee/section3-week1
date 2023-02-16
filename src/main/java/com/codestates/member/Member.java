package com.codestates.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Member {
    private long memberId;
    String email;

    String name;

    String phone;
}
