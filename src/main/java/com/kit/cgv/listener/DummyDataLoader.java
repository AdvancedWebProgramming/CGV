package com.kit.cgv.listener;

import com.kit.cgv.jpa.domain.member.Member;
import com.kit.cgv.jpa.domain.member.MemberRepository;
import com.kit.cgv.jpa.domain.movie.Movie;
import com.kit.cgv.jpa.domain.movie.MovieRepository;
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

    private Movie createMovieIfNotFound(Long movieId, String actor, LocalDate closingDate, LocalDate openingDate, String description, String director, String genre, String rate, String title){
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

    private RatingBoard createRatingBoardIfNotFound(Long ratingBoardId, Long movieId, Long memberId, String content, Double grade){
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
                        .grade(grade)
                        .likeCount(0L)
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
