package anuar.shop_spring.controller;

import anuar.shop_spring.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/review")
public class ReviewController {

    private final ReviewService reviewService;
}
