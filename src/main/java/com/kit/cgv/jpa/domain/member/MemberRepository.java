package com.kit.cgv.jpa.domain.member;

import com.kit.cgv.jpa.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByMemberLoginID(String memberLoginId);
}
