package com.nhn.mreview.repository;

import com.nhn.mreview.entity.Member;
import com.nhn.mreview.entity.Movie;
import com.nhn.mreview.entity.Review;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

    @EntityGraph(attributePaths = {"member"}, type = EntityGraph.EntityGraphType.FETCH)
    List<Review> findByMovie(Movie movie);

    @Modifying  //update, delete + @Query : 필수값
    @Query("delete from Review mr where mr.member = :member")
    void deleteByMember(Member member);

}
