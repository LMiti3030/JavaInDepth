package mititelu.laura.udemy.thrillio.managers;

import mititelu.laura.udemy.thrillio.dao.UserDao;
import mititelu.laura.udemy.thrillio.entities.User;

//manager or Service = use what the team is using
public class UserManager {

    private static UserManager instance;
    private static UserDao dao;

    private UserManager() {
        dao = new UserDao();
    }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public User createUSer(long id, String email, String password, String firstName, String lastName, int gender, String userType) {
        User user = new User();
        user.setId(id);
        user.setEmail(email);
        user.setPassword(password);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setGender(gender);
        user.setUserType(userType);
        return user;
    }

    public User[] getUsers(){
        if(dao == null){
            dao = new UserDao();
        }
        return dao.getUsers();
    }

}
