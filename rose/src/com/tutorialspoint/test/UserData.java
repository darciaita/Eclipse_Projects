package com.tutorialspoint.test;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userData", eager = true)
@SessionScoped
public class UserData implements Serializable {
   private static final long serialVersionUID = 1L;
   public String data = "1";
   public String userId;
   public String password;
   public String db;
   public String result;

   public String getResult() {
	return result;
}

public void setResult(String result) {
	this.result = result;
}

public String getDb() {
	return db;
}

public void setDb(String db) {
	this.db = db;
}

public String getUserId() {
	return userId;
}

public void setUserId(String userID) {
	this.userId = userID;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getData() {
      return data;
   }

   public void setData(String data) {
      this.data = data;
   }
}