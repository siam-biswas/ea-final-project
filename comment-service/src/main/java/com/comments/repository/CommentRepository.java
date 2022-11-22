package com.comments.repository;

import com.comments.entity.Comments;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepository extends CrudRepositoryInterface<Comments>{

}
