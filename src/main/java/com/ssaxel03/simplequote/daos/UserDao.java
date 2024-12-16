package com.ssaxel03.simplequote.daos;

import com.ssaxel03.simplequote.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends GenericDao<User> implements Dao<User> {
    public UserDao() {
        super(User.class);
    }
}
