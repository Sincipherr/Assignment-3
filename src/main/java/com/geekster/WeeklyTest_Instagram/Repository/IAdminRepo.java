package com.geekster.WeeklyTest_Instagram.Repository;

import com.geekster.WeeklyTest_Instagram.model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepo extends CrudRepository<Admin,Long> {
}
