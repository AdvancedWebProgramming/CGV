package com.kit.cgv.jpa.domain.likecount;

import com.kit.cgv.jpa.domain.common.BaseTimeEntity;
import com.kit.cgv.jpa.domain.member.Member;
import com.kit.cgv.jpa.domain.movie.Moive;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class LikeCount extends BaseTimeEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="LIKE_COUNT_ID")
	private Long likeCountId;
	
	@OneToOne
	@JoinColumn(name="MOVIE_ID", nullable = false)
	private Movie movie;
	
	@OneToMany(mappedBy = "memberID")
	private List<Member> members;
}
