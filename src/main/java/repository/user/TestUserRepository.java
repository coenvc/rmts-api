package repository.user;


import model.user.User;
import model.user.UserBuilder;

import java.util.ArrayList;
import java.util.List;

public class TestUserRepository implements UserRepository{

    public User login(String username, String password) {
        List<User> users = new ArrayList<User>();
        String pass1 = "Hallo";
        String pass2 = "Alloh";

        User u1 = new UserBuilder()
                .username("T.est")
                .password(pass1)
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

        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUsername() == username && (password == pass1 || password == pass2)){
                return users.get(i);
            }
        }


        return null;
    }

    public boolean insert(User user) {
        return user != null;
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
