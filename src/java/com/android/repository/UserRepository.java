package com.android.repository;

import com.android.base.BaseRepository;
import com.android.entity.User;
import java.util.List;

public class UserRepository extends BaseRepository<User> {

    public UserRepository() {
        super(User.class);
    }

    public User findUserByNickname(String userNick) {
        List<User> userList = super.list();
        User expectedUser = null;
        for (User user : userList) {
            if (user.getUserNick().equals(userNick)) {
                expectedUser = user;
                break;
            }
        }
        return expectedUser;
    }

}
