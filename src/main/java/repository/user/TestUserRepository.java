package repository.user;


import model.User;
import model.UserBuilder;

import java.util.ArrayList;
import java.util.List;

public class TestUserRepository implements UserRepository{

    public void insert(User user) {

    }

    public List getAll() {
        List<User> users = new ArrayList<User>();

        User u1 = new UserBuilder()
                .username("T.est")
                .password("Hallo")
                .name("Teun Est")
                .active(true)
                .build();

        User u2 = new UserBuilder()
                .username("D.emo")
                .password("Alloh")
                .name("Dirk Emo")
                .active(false)
                .build();

        users.add(u1);
        users.add(u2);

        return users;
    }

    public User find(int id) {
        User u1 = new UserBuilder()
                .username("T.est")
                .password("Hallo")
                .name("Teun Est")
                .active(true)
                .build();

        u1.setId(id);

        return u1;
    }
}
