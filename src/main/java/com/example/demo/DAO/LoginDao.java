package com.example.demo.DAO;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.demo.entity.login;
import com.example.demo.interfaces.LoginRepo;
/*
 * These class is like dao where we can add,delete and check data.
 */
@EnableAutoConfiguration
@Service
@Component
public class LoginDao {
	/*
	 *  autowired is use to auto wire bean on the setter method, constructor or a field.
	 */
	@Autowired
	LoginRepo loginrepo;
	//in these are going to check id,password by getting data from db.
	public String check(login log) {
		String role = null;
		ArrayList<login> loginbean1=(ArrayList<login>) loginrepo.findAll();
		for (int i = 0; i < loginbean1.size(); i++) {
			//if id and password is equal to db id and password it will tp thos method.
			if(log.getId()==loginbean1.get(i).getId()&&log.getPassword().equals(loginbean1.get(i).getPassword())) {
				 role="admin";
			}
			//if entered id and password is null than it will go to this block of code
			else if(loginbean1.get(i).equals(null)&&loginbean1.get(i).getPassword().equals(null)) {
				 role="error";
			}
			//if id or password is not correct it will to these block of code.
			else {
				 role="invalid";
			}
		}
		return role;
	}
	}


