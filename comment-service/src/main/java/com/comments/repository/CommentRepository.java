package com.comments.repository;

import com.comments.entity.Comments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface CommentRepository extends CrudRepository<Comments,Long> {

     List<Comments> findAll();
     Comments findAllById(Long id);
}
