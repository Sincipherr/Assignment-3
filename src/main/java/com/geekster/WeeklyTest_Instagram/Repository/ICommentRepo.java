package com.geekster.WeeklyTest_Instagram.Repository;

import com.geekster.WeeklyTest_Instagram.model.Comments;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICommentRepo extends CrudRepository<Comments,Long> {
}
