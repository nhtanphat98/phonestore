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
public class Constants implements Serializable{
    public static String FACEBOOK_APP_ID = "3741017742626595";
  public static String FACEBOOK_APP_SECRET = "2cc5d3ec35c6004bacd8b3a48e03ae74";
  public static String FACEBOOK_REDIRECT_URL = "http://localhost:8080/Assignment_PRJ321_SE140227/LoginFacebook";
  public static String FACEBOOK_LINK_GET_TOKEN = "https://graph.facebook.com/oauth/access_token?client_id=%s&client_secret=%s&redirect_uri=%s&code=%s";
}
