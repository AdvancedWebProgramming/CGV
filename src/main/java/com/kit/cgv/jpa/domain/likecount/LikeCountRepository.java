package com.kit.cgv.jpa.domain.likecount;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeCountRepository extends JpaRepository<Member, Long> {
}
