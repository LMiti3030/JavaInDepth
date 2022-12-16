package mititelu.laura.udemy.thrillio.dao;

import mititelu.laura.udemy.thrillio.DataStore;
import mititelu.laura.udemy.thrillio.entities.User;

public class UserDao {

    public User[] getUsers(){
        return DataStore.getUsers();
    }

}
