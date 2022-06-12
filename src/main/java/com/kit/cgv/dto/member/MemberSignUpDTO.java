package com.kit.cgv.dto.member;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.kit.cgv.jpa.domain.member.Member;
import lombok.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberSignUpDTO {
    private Long id;
    private String loginId;
    private String password;

    private String confrimPassword;
    private String name;
    private String birthday;

    public Member toEntity(){
        return Member.builder().memberLoginID(loginId)
                .birthday(LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .memberPWD(password)
                .name(name)
                .build();
    }
}
