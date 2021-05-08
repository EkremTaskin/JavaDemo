import Business.Abstracts.AuthService;
import Business.Abstracts.UserService;
import Business.Concretes.AuthManager;
import Business.Concretes.UserManager;
import Core.GoogleServiceManagerAdapter;
import DataAccess.Abstracts.UserDao;
import DataAccess.Concretes.HibernateUserDao;
import Entities.Concrete.User;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        User user1 = new User(1,"BarÄ±ÅŸ","Arslan","arslan1881@outlook.com","12345678910");
        User user2 = new User(2,"Mehmet","asdas","arslan@hotmail.com","12345600");
//        UserService userService = new UserManager(new HibernateUserDao());
//        userService.add(user1);
//        userService.add(user2);

        AuthService authService = new AuthManager(new UserManager(new HibernateUserDao()));
        if(authService.register(user1))
            System.out.println("Kayýt basarili");
        else
            System.out.println("Kayýt Basarisiz");
        
        if(authService.login(user1))
            System.out.println("Giris basarili");
        else
            System.out.println("Giris Basarisiz");
        
        
    }
}
