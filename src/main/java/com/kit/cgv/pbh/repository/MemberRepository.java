package com.kit.cgv.pbh.repository;

import com.kit.cgv.pbh.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {
}
