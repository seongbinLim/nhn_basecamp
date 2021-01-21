package com.nhn.mreview.service;

import com.nhn.mreview.dto.ReviewDTO;
import com.nhn.mreview.entity.Member;
import com.nhn.mreview.entity.Movie;
import com.nhn.mreview.entity.Review;

import java.util.List;

public interface ReviewService {
    //영화의 모든 영화리뷰를 가져온다.
    List<ReviewDTO> getListOfMovie(Long mno);
    //영화리뷰 추가
    Long register(ReviewDTO reviewDTO);
    //특정 영화리뷰 수정
    void modify(ReviewDTO reviewDTO);
    //영화리뷰 삭제
    void remove(Long reviewnum);

    default Review dtoToEntity(ReviewDTO reviewDTO) {
        Review movieReview = Review.builder()
                .reviewnum(reviewDTO.getReviewnum())
                .movie(Movie.builder().mno(reviewDTO.getMno()).build())
                .member(Member.builder().mid(reviewDTO.getMid()).build())
                .grade(reviewDTO.getGrade())
                .text(reviewDTO.getText())
                .build();

        return movieReview;
    }

    default ReviewDTO entityToDto(Review review) {
        ReviewDTO reviewDTO = ReviewDTO.builder()
                .reviewnum(review.getReviewnum())
                .mno(review.getMovie().getMno())
                .mid(review.getMember().getMid())
                .nickname(review.getMember().getNickname())
                .email(review.getMember().getEmail())
                .grade(review.getGrade())
                .text(review.getText())
                .regDate(review.getRegDate())
                .modDate(review.getModDate())
                .build();

        return reviewDTO;

    }
}
