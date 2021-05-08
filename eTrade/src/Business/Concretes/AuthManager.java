package Business.Concretes;

import Business.Abstracts.AuthService;
import Business.Abstracts.UserService;
import DataAccess.Abstracts.UserDao;
import Entities.Concrete.User;

import java.util.regex.Pattern;

public class AuthManager implements AuthService {

	UserService userService;
	
    public AuthManager(UserService userService) {
    	this.userService = userService;
    }
	
    public boolean validate(User user) {
        if(user.getPassword().length()>6 &&
                user.getFirstName().length()>2 &&
                user.getLastName().length()>2 &&
                isValidEmail(user.geteMail()))
        {
            return true;
        }else
            return false;
    }

    @Override
    public boolean login(User user) {
    	var results = userService.GetUsers();
    	for(var result : results) {
    		if((user.geteMail()==result.geteMail()))
                return true;
    	}
    	return false;
        
    }

    public boolean isValidEmail(String email) {
        String emailRegex = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{3}\\b";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		if(this.validate(user)) {
		   this.userService.add(user);
		   return true;
		}
		return false;
	}
}
