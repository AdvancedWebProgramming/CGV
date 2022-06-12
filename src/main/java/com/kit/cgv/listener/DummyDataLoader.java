package com.kit.cgv.listener;

import com.kit.cgv.jpa.domain.member.Member;
import com.kit.cgv.jpa.domain.member.MemberRepository;
import com.kit.cgv.jpa.domain.movie.Movie;
import com.kit.cgv.jpa.domain.movie.MovieRepository;
import com.kit.cgv.jpa.domain.movieposter.MoviePoster;
import com.kit.cgv.jpa.domain.movieposter.MoviePosterRepository;
import com.kit.cgv.jpa.domain.ratingboard.RatingBoard;
import com.kit.cgv.jpa.domain.ratingboard.RatingBoardRepository;
import com.kit.cgv.jpa.domain.reservation.Reservation;
import com.kit.cgv.jpa.domain.reservation.ReservationRepository;
import com.kit.cgv.jpa.domain.reservationdetail.ReservationDetail;
import com.kit.cgv.jpa.domain.reservationdetail.ReservationDetailRepository;
import com.kit.cgv.jpa.domain.reservationdistribution.ReservationDistributionRepository;
import com.kit.cgv.jpa.domain.screen.Screen;
import com.kit.cgv.jpa.domain.screen.ScreenRepository;
import com.kit.cgv.jpa.domain.screendetail.ScreenDetail;
import com.kit.cgv.jpa.domain.screendetail.ScreenDetailRepository;
import com.kit.cgv.jpa.domain.seat.Seat;
import com.kit.cgv.jpa.domain.seat.SeatRepository;
import com.kit.cgv.jpa.domain.theater.Theater;
import com.kit.cgv.jpa.domain.theater.TheaterRepository;
import com.kit.cgv.jpa.domain.trailer.TrailerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Slf4j
@ConfigurationProperties(prefix ="property.test")
@Component
@RequiredArgsConstructor
public class DummyDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    private final MemberRepository memberRepository;
    private final MovieRepository movieRepository;
    private final TheaterRepository theaterRepository;
    private final ScreenRepository screenRepository;
    private final ScreenDetailRepository screenDetailRepository;
    private final MoviePosterRepository moviePosterRepository;
    private final ReservationRepository reservationRepository;
    private final ReservationDetailRepository reservationDetailRepository;
    private final SeatRepository seatRepository;
    private final TrailerRepository trailerRepository;
    private final RatingBoardRepository ratingBoardRepository;
    private final ReservationDistributionRepository reservationDistributionRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {
        loadMemberData();
        loadMovieData();
        loadPosterData();
    }

    private void loadMemberData(){
        createMemberIfNotFound(1L, "DUMMY_LOGIN_ID"+1L, "DUMMY_PASSWORD"+1L, "DUMMY_NAME1", LocalDate.of(1999, 5, 12));
        createMemberIfNotFound(2L, "DUMMY_LOGIN_ID"+2L, "DUMMY_PASSWORD"+2L, "DUMMY_NAME2", LocalDate.of(1998, 5, 12));
        createMemberIfNotFound(3L, "DUMMY_LOGIN_ID"+3L, "DUMMY_PASSWORD"+3L, "DUMMY_NAME3", LocalDate.of(1997, 5, 12));
        createMemberIfNotFound(4L, "DUMMY_LOGIN_ID"+4L, "DUMMY_PASSWORD"+4L, "DUMMY_NAME4", LocalDate.of(2015, 5, 12));
    }

    private void loadPosterData(){
        createMoviePosterIfNotFound(1L, 1L, "탑건Poster.png");
        createMoviePosterIfNotFound(2L, 2L, "마녀Poster.png");
        createMoviePosterIfNotFound(3L, 3L,"버즈Poster.png");
        createMoviePosterIfNotFound(4L, 4L, "범죄도시Poster.png");
        createMoviePosterIfNotFound(5L, 5L, "브로커Poster.png");
        createMoviePosterIfNotFound(6L, 6L, "쥬라기월드Poster.png");
        createMoviePosterIfNotFound(7L, 7L,"애프터양Poster.png");
        createMoviePosterIfNotFound(8L,8L,"기라티나Poster.png");
        createMoviePosterIfNotFound(9L, 9L, "박쥐Poster.png");
        createMoviePosterIfNotFound(10L, 10L, "아가씨Poster.png");
        createMoviePosterIfNotFound(11L, 11L, "닥터스트레인지Poster.png");
    }

    private void loadMovieData(){
        createMovieIfNotFound(1L, "톰 크루즈, 마일즈 텔러, 제니퍼 코넬리", LocalDate.of(2022,8,16), LocalDate.of(2022,6,12),"한순간의 실수도 용납되지 않는 하늘 위, \n" +
                "가장 압도적인 비행이 시작된다!\n" +
                "\n" +
                "최고의 파일럿이자 전설적인 인물 매버릭(톰 크루즈)은 자신이 졸업한 훈련학교 교관으로 발탁된다. \n" +
                "그의 명성을 모르던 팀원들은 매버릭의 지시를 무시하지만 실전을 방불케 하는 상공 훈련에서 눈으로 봐도 믿기 힘든 전설적인 조종 실력에 모두가 압도된다. \n" +
                "\n" +
                "매버릭의 지휘아래 견고한 팀워크를 쌓아가던 팀원들에게 국경을 뛰어넘는 위험한 임무가 주어지자\n" +
                "매버릭은 자신이 가르친 동료들과 함께 마지막이 될 지 모를 하늘 위 비행에 나서는데… ","조셉 코신스키", "액션","12세 이상", "탑건-매버릭", 130L);
        createMovieIfNotFound(2L, "신시아, 박은빈, 서은수, 진구, 성유빈, 조민수, 이종석, 김다미", LocalDate.of(2022,8,16), LocalDate.of(2022,6,12), "통제불능의 존재가 세상 밖으로 나왔다!\n" +
                " \n" +
                "‘자윤’이 사라진 뒤, 정체불명의 집단의 무차별 습격으로 마녀 프로젝트가 진행되고 있는 ‘아크’가 초토화된다.\n" +
                "그곳에서 홀로 살아남은 ‘소녀’는 생애 처음 세상 밖으로 발을 내딛고\n" +
                "우연히 만난 ‘경희’의 도움으로 농장에서 지내며 따뜻한 일상에 적응해간다.\n" +
                "한편, ‘소녀’가 망실되자 행방을 쫓는 책임자 ‘장’과\n" +
                "마녀 프로젝트의 창시자 ‘백총괄’의 지령을 받고 제거에 나선 본사 요원 ‘조현’,\n" +
                "‘경희’의 농장 소유권을 노리는 조직의 보스 ‘용두’와\n" +
                "상해에서 온 의문의 4인방까지\n" +
                "각기 다른 목적을 지닌 세력이 하나 둘 모여들기 시작하면서 ‘소녀’ 안에 숨겨진 본성이 깨어나는데…\n" +
                " \n" +
                "모든 것의 시작,\n" +
                "더욱 거대하고 강력해진 마녀가 온다.", "박훈정", "액션","15세 이상","마녀(魔女) Part2. The Other One", 137L);
        createMovieIfNotFound(3L, "크리스 애반스, 타이카 와이티티, 피터 손", LocalDate.of(2022,8,16), LocalDate.of(2022,6,12), "우주 저 너머 운명을 건 미션, 무한한 모험이 시작된다!\n" +
                "\n" +
                "미션 #1\n" +
                "나, 버즈 라이트이어.\n" +
                "인류 구원에 필요한 자원을 감지하고 현재 수많은 과학자들과 미지의 행성으로 향하고 있다.\n" +
                "이번 미션은 인류의 역사를 새롭게 쓸 것이라 확신한다.\n" +
                "\n" +
                "미션 #2\n" +
                "잘못된 신호였다.\n" +
                "이곳은 삭막하고 거대한 외계 생물만이 살고 있는 폐허의 땅이다.\n" +
                "나의 실수로 모두가 이곳에 고립되고 말았다.\n" +
                "모두를 구하기 위해서 모든 것을 제자리에 돌려 놔야 한다.\n" +
                "\n" +
                "미션 #3\n" +
                "실수를 바로잡기 위한 탈출 미션을 위해 1년의 준비를 마쳤다.\n" +
                "어쩌다 한 팀이 된 정예 부대와 이 미션을 수행할 예정이다.\n" +
                "우주를 집어삼킬 ‘저그’와 대규모 로봇 군사의 위협이 계속되지만\n" +
                "나는 절대 포기할 수 없다.\n" +
                "그런데… 여긴 또 어디지? 시간 속에 갇힌 건가?", "앤거슨 맥클레인","애니메이션","전체","버즈 라이트이어", 105L);

        createMovieIfNotFound(4L,"마동석, 손석구, 최귀화, 박지환, 허동원, 하준, 정재광", LocalDate.of(2022,8,16), LocalDate.of(2022,5,18),"“느낌 오지? 이 놈 잡아야 하는 거”\n" +
                "\n" +
                "가리봉동 소탕작전 후 4년 뒤,\n" +
                "금천서 강력반은 베트남으로 도주한 용의자를 인도받아 오라는 미션을 받는다.\n" +
                "\n" +
                "괴물형사 ‘마석도’(마동석)와 ‘전일만’(최귀화) 반장은 현지 용의자에게서 수상함을 느끼고,\n" +
                "그의 뒤에 무자비한 악행을 벌이는 ‘강해상’(손석구)이 있음을 알게 된다.\n" +
                "\n" +
                "‘마석도’와 금천서 강력반은 한국과 베트남을 오가며\n" +
                " 역대급 범죄를 저지르는 ‘강해상’을 본격적으로 쫓기 시작하는데...\n" +
                "\n" +
                "나쁜 놈들 잡는 데 국경 없다!\n" +
                "통쾌하고 화끈한 범죄 소탕 작전이 다시 펼쳐진다! ", "이상용", "범죄, 액션", "15세 이상", "범죄도시 2", 106L);
        createMovieIfNotFound(5L, "송강호, 강동원, 배두나, 이지은, 이주영", LocalDate.of(2022,8,16), LocalDate.of(2022,6,8), "세탁소를 운영하지만 늘 빚에 시달리는 ‘상현’(송강호)과\n" +
                "베이비 박스 시설에서 일하는 보육원 출신의 ‘동수’(강동원).\n" +
                "거센 비가 내리는 어느 날 밤,\n" +
                "그들은 베이비 박스에 놓인 한 아기를 몰래 데려간다.\n" +
                "하지만 이튿날, 생각지 못하게 엄마 ‘소영’(이지은)이 아기 ‘우성’을 찾으러 돌아온다.\n" +
                "아기가 사라진 것을 안 소영이 경찰에 신고하려 하자 솔직하게 털어놓는 두 사람.\n" +
                "우성이를 잘 키울 적임자를 찾아 주기 위해서 그랬다는 변명이 기가 막히지만\n" +
                "소영은 우성이의 새 부모를 찾는 여정에 상현, 동수와 함께하기로 한다.\n" +
                "\n" +
                "한편 이 모든 과정을 지켜본 형사 ‘수진’(배두나)과 후배 ‘이형사’(이주영).\n" +
                "이들을 현행범으로 잡고 반 년째 이어온 수사를 마무리하기 위해 조용히 뒤를 쫓는다.\n" +
                "\n" +
                "베이비 박스,\n" +
                "그곳에서 의도치 않게 만난 이들의\n" +
                "예기치 못한 특별한 여정이 시작된다.", "고레에다 히로카즈", "드라마", "12세 이상", "브로커", 129L);

        createMovieIfNotFound(6L, "크리스 프랫, 브라이스 달라스 하워드, 드완다 와이즈, 로라 던, 제프 골드브럼, 샘 닐", LocalDate.of(2022,8,16), LocalDate.of(2022,6,1), "", "콜린 트레보로우", "액션, 어드벤쳐", "12세 이상", "쥬라기 월드-도미니언", 147L);
        createMovieIfNotFound(7L, "콜린 파렐, 조디 터너 스미스, 저스틴 H.민, 말레아 엠마 찬드로위자야", LocalDate.of(2022,8,16), LocalDate.of(2022,6,1), "함께 살던 안드로이드 인간 ‘양’이 어느 날 작동을 멈추자\n" +
                "제이크 가족은 그를 수리할 방법을 찾는다.\n" +
                "그러던 중, ‘양’에게서 특별한 메모리 뱅크를 발견하고\n" +
                "그의 기억을 탐험하기 시작하는데…\n" +
                "\n" +
                "무엇을 남기고 싶었어, 양?", "코고나다", "드라마", "전체", "애프터 양",96L);
        createMovieIfNotFound(8L, "이선호, 김영선", LocalDate.of(2022,8,16), LocalDate.of(2022,6,1), "끝나지 않은 전설의 포켓몬들의 배틀로\n" +
                "위험에 빠진 반전 세계와 현실 세계를 구하기 위해\n" +
                "감사포켓몬 ‘쉐이미’와 ‘지우’, ‘피카츄’가 나서면서 시작되는 모험 이야기", "유야마 쿠니히코", "애니메이션", "전체", "극장판 포켓몬스터DP-기라티나와 하늘의 꽃다발 쉐이미",96L);
        createMovieIfNotFound(9L, "송강호, 김옥빈", LocalDate.of(2022,8,16), LocalDate.of(2017,7,27), "뱀파이어가 된 신부, 친구의 아내를 탐하다\n" +
                "\n" +
                "병원에서 근무하는 신부 ‘상현’은 죽어가는 환자들을 보고만 있어야 하는 자신의 무기력함에 괴로워 하다가 해외에서 비밀리에 진행되는 백신개발 실험에 자발적으로 참여한다. 그러나 실험 도중 바이러스 감염으로 죽음에 이르고, 정체불명의 피를 수혈 받아 기적적으로 소생한다. 하지만 그 피는 상현을 뱀파이어로 만들어버렸다. 피를 원하는 육체적 욕구와 살인을 원치 않는 신앙심의 충돌은 상현을 짓누르지만 피를 먹지 않고 그는 살 수가 없다. 하지만 살인하지 않고 사람의 피를 어떻게 구한단 말인가?\n" +
                " 기적적으로 생명을 건진 상현은 그가 기적을 일으킬 수 있다고 믿고 기도를 청하는 신봉자들 사이에서 어린 시절 친구 ‘강우’와 그의 아내 ‘태주’를 만나게 된다. 뱀파이어가 된 상현은 태주의 묘한 매력에 억누를 수 없는 욕망을 느낀다. 태주 또한 히스테리컬한 시어머니와 무능력한 남편에게 억눌렸던 욕망을 일깨워준 상현에게 집착하고 위험한 사랑에 빠져든다. 모든 것을 포기할 만큼 태주를 사랑하게 된 상현은 끝내 신부의 옷을 벗고 그녀의 세계로 들어 간다. 인간적 욕망의 기쁨이 이런 것이었던가. 이제 모든 쾌락을 갈구하게 된 상현은 신부라는 굴레를 벗어 던진다.\n" +
                " 점점 더 대담해져만 가는 상현과 태주의 사랑. 상현이 뱀파이어라는 사실을 알게 된 태주는 두려움에 거리를 두지만 그것도 잠시, 상현의 가공할 힘을 이용해 남편을 죽이자고 유혹한다. 사랑이란 이름으로 더욱 그를 조여오는 태주. 살인만은 피하고자 했던 상현은 결국 태주를 위해 강우를 죽이기 위한 그녀의 제안을 받아들이는데… 한치 앞을 알 수 없는 이들의 사랑, 과연 그 끝은 어떻게 될까.\n" +
                "\n" +
                " \n" +
                "\n" +
                "* CGV용산아이파크몰 아트하우스 박찬욱관 오픈 기념으로 리마스터링된 작품이며 확장판으로 상영됩니다.", "반찬욱", "호러, 드라마", "미정", "박쥐 확장판", 147L);
        createMovieIfNotFound(10L, "김민희, 김태리, 하정우, 조진웅, 김해숙, 문소리", LocalDate.of(2022,8,16), LocalDate.of(2016,9,1), "어릴 적 부모를 잃고 후견인 이모부(조진웅)의 엄격한 보호 아래 살아가는 귀족 아가씨(김민희).\n" +
                "그녀에게 백작이 추천한 새로운 하녀가 찾아온다.\n" +
                "\n" +
                "매일 이모부의 서재에서 책을 읽는 것이 일상의 전부인 외로운 아가씨는\n" +
                "\n" +
                "순박해 보이는 하녀에게 조금씩 의지하기 시작한다.\n" +
                "\n" +
                " \n" +
                "\n" +
                "하지만 하녀의 정체는 유명한 여도둑의 딸로, 장물아비 손에서 자란 소매치기 고아 소녀 숙희(김태리).\n" +
                "\n" +
                "막대한 재산을 상속받게 될 아가씨를 유혹하여 돈을 가로채겠다는 사기꾼 백작(하정우)의 제안을 받고\n" +
                "\n" +
                "아가씨가 백작을 사랑하게 만들기 위해 하녀가 된 것.\n" +
                "\n" +
                "드디어 백작이 등장하고, 백작과 숙희는 자신만의 방식으로 아가씨의 마음을 흔들기 시작하는데…\n" +
                "\n" +
                " \n" +
                "\n" +
                "돈과 마음을 뺏기 위해 서로 속고 속이는\n" +
                "\n" +
                "매혹적인 그들의 이야기가 시작된다!", "박찬욱", "드라마, 스릴러", "청소년 관람불가", "아가씨 확장판", 167L);
        createMovieIfNotFound(11L, "베네딕트 컴버배치, 엘리자베스 올슨, 베네딕트 웡, 레이첼 맥아담스, 치웨텔 에지오포, 소치를 고메즈", LocalDate.of(2022,8,16), LocalDate.of(2022,5,4), "지금껏 본 적 없는 마블의 극한 상상력!\n" +
                "5월, 광기의 멀티버스가 깨어난다!\n" +
                "  \n" +
                "끝없이 균열되는 차원과 뒤엉킨 시공간의 멀티버스가 열리며\n" +
                "오랜 동료들, 그리고 차원을 넘어 들어온 새로운 존재들을 맞닥뜨리게 된 ‘닥터 스트레인지’.\n" +
                "대혼돈 속, 그는 예상치 못한 극한의 적과 맞서 싸워야만 하는데….", "샘 레이미", "액션, 어드벤처, 환타지", "12세 이상", "닥터 스트레인지-대혼돈의 멀티버스", 126L);
    }

    private MoviePoster createMoviePosterIfNotFound(Long moviePosterId, Long movieId, String fileName){
        Optional<MoviePoster> findMoviePoster = moviePosterRepository.findById(moviePosterId);
        if(findMoviePoster.isPresent()){
            return findMoviePoster.get();
        }

        Optional<Movie> findMovie = movieRepository.findById(movieId);
        if(findMovie.isEmpty()){
            log.warn("createMoviePosterIfNotFound :: movieId == null");
            return null;
        }

        return moviePosterRepository.save(MoviePoster.builder()
                .id(moviePosterId)
                .movie(findMovie.get())
                .path("C:\\Users\\khj74\\IdeaProjects\\CGV\\src\\main\\resources\\public\\static\\images\\"+fileName)
                .fileName(fileName)
                .build());
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

    private Movie createMovieIfNotFound(Long movieId, String actor, LocalDate closingDate, LocalDate openingDate, String description, String director, String genre, String rate, String title, Long runTime){
        Optional<Movie> findMovie = movieRepository.findById(movieId);

        if(findMovie.isPresent()){
            return findMovie.get();
        }

        return movieRepository.save(
                Movie.builder()
                        .actors(actor)
                        .movieId(movieId)
                        .closingDate(closingDate)
                        .description(description)
                        .genre(genre)
                        .directors(director)
                        .rate(rate)
                        .openingDate(openingDate)
                        .watcherCount(0L)
                        .runtime(runTime)
                        .title(title).build()
        );
    }

    private Theater createTheaterIfNotFound(Long theaterId, Long columnMany, Long rowMany, Long theaterNum){
        Optional<Theater> findTheater = theaterRepository.findById(theaterId);

        if(findTheater.isPresent()){
            return findTheater.get();
        }

        return theaterRepository.save(Theater.builder()
                .theaterId(theaterId)
                .columnMany(columnMany)
                .rowMany(rowMany)
                .build());
    }

    private RatingBoard createRatingBoardIfNotFound(Long ratingBoardId, Long movieId, Long memberId, String content, Boolean isGood){
        Optional<RatingBoard> findRatingBoard = ratingBoardRepository.findById(ratingBoardId);

        if(findRatingBoard.isPresent()){
            return findRatingBoard.get();
        }

        Optional<Movie> findMovie = movieRepository.findById(movieId);
        Optional<Member> findMember = memberRepository.findById(memberId);

        if(findMovie.isEmpty()){
            log.warn("createRatingBoard :: movieId == null");
            return null;
        }

        if(findMember.isEmpty()){
            log.warn("createRatingBoard :: userId == null");
            return null;
        }


        return ratingBoardRepository.save(
                RatingBoard.builder()
                        .ratingBoardId(ratingBoardId)
                        .movie(findMovie.get())
                        .content(content)
                        .likeCount(0L)
                        .isGood(isGood)
                        .writer(findMember.get())
                        .build()
        );
    }

    private Reservation createReservationIfNotFound(Long reservationId, Long screenId, Long price, Long count){
        Optional<Reservation> findReservation = reservationRepository.findById(reservationId);

        if(findReservation.isPresent()){
            return findReservation.get();
        }

        Optional<Screen> findScreen = screenRepository.findById(screenId);
        if(findScreen.isEmpty()){
            log.warn("createReservation :: screenId == null");
            return null;
        }

        return reservationRepository.save(
                Reservation.builder()
                        .reservationID(reservationId)
                        .count(count)
                        .price(price)
                        .screen(findScreen.get())
                        .build()
        );
    }

    private ReservationDetail createReservationDetailIfNotFound(Long reservationDetailId, Long reservationId, Long seatId){
        Optional<ReservationDetail> findReservationDetail = reservationDetailRepository.findById(reservationDetailId);

        if(findReservationDetail.isPresent()){
            return findReservationDetail.get();
        }

        Optional<Reservation> findReservation = reservationRepository.findById(reservationId);
        if(findReservation.isEmpty()){
            log.warn("createReservationDetail :: reservationId == null");
            return null;
        }

        Optional<Seat> findSeat = seatRepository.findById(seatId);
        if(findSeat.isEmpty()){
            log.warn("createReservationDetail :: seatId == null");
            return null;
        }

        return reservationDetailRepository.save(
                ReservationDetail.builder()
                        .reservation(findReservation.get())
                        .reservationDetailID(reservationDetailId)
                        .seat(findSeat.get())
                        .build()
        );
    }

    private Seat createSeatIfNotFound(Long seatId, Long theaterId, Long colNum, Long rowNum, Boolean isAble, String seatDescription){
        Optional<Seat> findSeat = seatRepository.findById(seatId);

        if(findSeat.isPresent()){
            return findSeat.get();
        }

        Optional<Theater> findTheater = theaterRepository.findById(theaterId);

        if(findTheater.isEmpty()){
            log.warn("createSeat :: theaterId == null");
            return null;
        }

        return seatRepository.save(
                Seat.builder()
                        .colNum(colNum)
                        .seatId(seatId)
                        .isAble(isAble)
                        .rowNum(rowNum)
                        .theater(findTheater.get())
                        .seatDescription(seatDescription).build()
        );
    }

    private Screen createScreenIfNotFound(Long screenId, Long movieId){
        Optional<Screen> findScreen = screenRepository.findById(screenId);

        if(findScreen.isPresent()){
            return findScreen.get();
        }

        Optional<Movie> findMovie = movieRepository.findById(movieId);

        if(findMovie.isEmpty()){
            log.warn("createScreen :: movieId == null");
            return null;
        }

        return screenRepository.save(
          Screen.builder()
                  .screenId(screenId)
                  .movie(findMovie.get())
                  .build()
        );
    }

    private ScreenDetail createScreenDetailIfNotFound(Long screenDetailId, Long screenId, Long theaterId, Long screenNum, LocalTime screenTime){
        Optional<ScreenDetail> findScreenDetail = screenDetailRepository.findById(screenDetailId);

        if(findScreenDetail.isPresent()){
            return findScreenDetail.get();
        }

        Optional<Screen> findScreen = screenRepository.findById(screenId);
        if(findScreenDetail.isEmpty()){
            log.warn("createScreenDetail :: screenId == null");
            return null;
        }

        Optional<Theater> findTheater = theaterRepository.findById(theaterId);
        if(findScreen.isEmpty()){
            log.warn("createScreenDetail :: theaterId == null");
            return null;
        }

        return screenDetailRepository.save(
          ScreenDetail.builder()
                  .screenDetailID(screenDetailId)
                  .screen(findScreen.get())
                  .screenNum(screenNum)
                  .screenTime(screenTime)
                  .people(0L)
                  .theater(findTheater.get())
                  .build()
        );
    }
}
