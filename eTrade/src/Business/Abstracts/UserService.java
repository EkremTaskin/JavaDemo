package Business.Abstracts;

import java.util.ArrayList;
import java.util.List;

import Entities.Concrete.User;

public interface UserService {
    void add(User user);
    List<User> GetUsers();


    

}
