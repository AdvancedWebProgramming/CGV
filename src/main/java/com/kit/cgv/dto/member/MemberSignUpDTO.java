package com.kit.cgv.dto.member;

import com.kit.cgv.jpa.domain.member.Member;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberSignUpDTO {
    private String id;
    private String password;
    private String name;
    private LocalDate birthday;

    public Member toEntity(){
        return Member.builder().memberLoginID(id)
                .birthday(birthday)
                .memberPWD(password)
                .name(name)
                .build();
    }
}
