
package com.android.service;

import com.android.entity.User;
import com.android.repository.UserRepository;


public class Test {
    public static void main(String[] args) {
        
        UserRepository rep = new UserRepository();
        
        User u = rep.findUserByNickname("omers");
        
        System.out.println("nick " + u.getUserNick());
        
    }
}
