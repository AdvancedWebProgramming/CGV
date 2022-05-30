package com.kit.cgv.listener;

import com.kit.cgv.jpa.domain.member.Member;
import com.kit.cgv.jpa.domain.member.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@ConfigurationProperties(prefix ="property.test")
@Component
@AllArgsConstructor
public class DummyDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private MemberRepository memberRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadMemberData();
    }

    private void loadMemberData(){
        createMemberIfNotFound(1L, "DUMMY_LOGIN_ID"+1L, "DUMMY_PASSWORD"+1L, "DUMMY_NAME1", LocalDate.of(1999, 5, 12));
        createMemberIfNotFound(2L, "DUMMY_LOGIN_ID"+2L, "DUMMY_PASSWORD"+2L, "DUMMY_NAME2", LocalDate.of(1998, 5, 12));
        createMemberIfNotFound(3L, "DUMMY_LOGIN_ID"+3L, "DUMMY_PASSWORD"+3L, "DUMMY_NAME3", LocalDate.of(1997, 5, 12));
        createMemberIfNotFound(4L, "DUMMY_LOGIN_ID"+4L, "DUMMY_PASSWORD"+4L, "DUMMY_NAME4", LocalDate.of(2015, 5, 12));
    }

    private Member createMemberIfNotFound(Long memberId, String memberLoginId, String memberPWD, String name, LocalDate birthday){
        Optional<Member> findMember = memberRepository.findById(memberId);

        if(findMember.isPresent()){
            return findMember.get();
        }

        return memberRepository.save(Member.builder().memberID(memberId)
                .birthday(birthday)
                .memberLoginID(memberLoginId)
                .memberPWD(memberPWD)
                .name(name)
                .build());
    }
}
