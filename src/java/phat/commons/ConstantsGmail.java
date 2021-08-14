/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phat.commons;

import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class ConstantsGmail implements Serializable{
    public static String GOOGLE_CLIENT_ID = "1096737237119-2tapsofovb2olka5sfhkqg1sshe99e1v.apps.googleusercontent.com";
  public static String GOOGLE_CLIENT_SECRET = "2aDtWbef9tgTmdZ_aIflPlZQ";
  public static String GOOGLE_REDIRECT_URI = "http://localhost:8080/Assignment_PRJ321_SE140227/LoginGmail";
  public static String GOOGLE_LINK_GET_TOKEN = "https://accounts.google.com/o/oauth2/token";
  public static String GOOGLE_LINK_GET_USER_INFO = "https://www.googleapis.com/userinfo/v2/me?access_token=";
  public static String GOOGLE_GRANT_TYPE = "authorization_code";
  
}
