package com.kit.cgv.controller.movie;

import com.kit.cgv.service.impl.MovieServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor

public class MovieController {
    private final MovieServiceImpl movieService;

    @GetMapping("")
    public ResponseEntity<?> movies(Model model, @PageableDefault(size=19, sort="id", direction = Sort.Direction.DESC) Pageable pageable){ // size can be revisable
        model.addAttribute("movies", movieService.listContents(pageable));
        return new ResponseEntity(model, HttpStatus.OK);
    }

    @GetMapping("/detail-view/?midx={midx}")
    public ResponseEntity detailView(Model model, @PathVariable Long midx){
        model.addAttribute("details", movieService.viewDetails(midx));
        return new ResponseEntity(model, HttpStatus.OK);
    }

}
