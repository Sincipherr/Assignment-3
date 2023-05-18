package com.geekster.WeeklyTest_Instagram.Repository;

import com.geekster.WeeklyTest_Instagram.model.AuthenticationToken;
import com.geekster.WeeklyTest_Instagram.model.User;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationRepo extends CrudRepository<AuthenticationToken,Long> {
    AuthenticationToken findByUser(User user);

    AuthenticationToken findFirstByToken(String token);
}
