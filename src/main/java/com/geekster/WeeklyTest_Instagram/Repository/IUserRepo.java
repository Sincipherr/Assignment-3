package com.geekster.WeeklyTest_Instagram.Repository;

import com.geekster.WeeklyTest_Instagram.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends CrudRepository<User,Long> {
    User findFirstByEmail(String userEmail);

    @Modifying
    @Query(value = "update user set email= :email where id= :id",nativeQuery = true)
    void updateuser(Integer id, String email);

    User findByUserId(Long id);
}
