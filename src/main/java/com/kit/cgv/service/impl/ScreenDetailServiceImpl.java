package com.kit.cgv.service.impl;

import com.kit.cgv.dto.screendetail.ScreenDetailDTO;
import com.kit.cgv.dto.screendetail.ScreenDetailUpdateDTO;
import com.kit.cgv.jpa.domain.screendetail.ScreenDetail;
import com.kit.cgv.jpa.domain.screendetail.ScreenDetailRepository;
import com.kit.cgv.service.ScreenDetailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ScreenDetailServiceImpl implements ScreenDetailService {

    private final ScreenDetailRepository screenDetailRepository;

    @Override
    public List<ScreenDetailDTO> getListWithMovieId(Long movieId) {
        List<ScreenDetail> screenDetails = screenDetailRepository.findWithMovieId(movieId);
        return screenDetails.stream().map(screenDetail -> ScreenDetailDTO.builder()
                .screen_detail_id(screenDetail.getScreenDetailID())
                .movie_id(screenDetail.getScreen().getMovie().getMovieId())
                .seat(screenDetail.getSeat())
                .time(String.format("%02d:%02d",screenDetail.getScreenTime().getHour(), screenDetail.getScreenTime().getMinute())).build()).collect(Collectors.toList());
    }

    @Override
    public List<ScreenDetailDTO> getLists() {
        List<ScreenDetail> screenDetails = screenDetailRepository.findAll();

        return screenDetails.stream().map(screenDetail -> ScreenDetailDTO.builder()
                .screen_detail_id(screenDetail.getScreenDetailID())
                .movie_id(screenDetail.getScreen().getMovie().getMovieId())
                .seat(screenDetail.getSeat())
                .time(String.format("%02d:%02d",screenDetail.getScreenTime().getHour(), screenDetail.getScreenTime().getMinute())).build()).collect(Collectors.toList());
    }

    @Override
    public ResponseEntity updateScreenDetailWithFixedRate(ScreenDetailUpdateDTO dto) {
        ScreenDetail findScreenDetail = screenDetailRepository.getById(dto.getScreen_detail_id());
        if(findScreenDetail.getDiscount() != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 정액할인이 되어있습니다.");
        }

        findScreenDetail.setFixedRate(dto.getFixedrate());
        screenDetailRepository.save(findScreenDetail);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @Override
    public ResponseEntity updateScreenDetailWithDiscount(ScreenDetailUpdateDTO dto) {
        ScreenDetail findScreenDetail = screenDetailRepository.getById(dto.getScreen_detail_id());
        if(findScreenDetail.getFixedRate() != null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("이미 정률할인이 되어있습니다.");
        }

        findScreenDetail.setDiscount(dto.getDiscount());
        screenDetailRepository.save(findScreenDetail);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
