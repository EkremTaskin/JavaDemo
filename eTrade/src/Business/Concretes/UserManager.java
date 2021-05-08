package Business.Concretes;

import Business.Abstracts.AuthService;
import Business.Abstracts.UserService;
import DataAccess.Abstracts.UserDao;
import Entities.Concrete.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager implements UserService {

	private UserDao userDao;
	private String sonuc = null;

	public UserManager(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void add(User user) {
		sonuc = userDao.add(user);
		System.out.println(user.getFirstName() + " " + user.getLastName() + " sisteme eklendi.");
		System.out.println(sonuc);
	}

	public boolean isExists(String email) {
		for (User user : userDao.getAllUser()) {
			if (email.equals(user.geteMail())) {
				System.out.println("Kullanıcı maili kullanımda.");
				return false;
			}
		}
		return true;
	}

	@Override
	public List<User> GetUsers() {
		// TODO Auto-generated method stub
		return userDao.getAllUser();
	}
	
	

}
