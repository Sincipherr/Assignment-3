package com.geekster.WeeklyTest_Instagram.Repository;

import com.geekster.WeeklyTest_Instagram.model.Following;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFollowingRepo extends CrudRepository<Following,Long> {
}
