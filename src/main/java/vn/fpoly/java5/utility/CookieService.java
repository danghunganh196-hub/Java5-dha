package vn.fpoly.java5.utility;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface CookieService {
    Cookie createCookie(String name, String value, Integer maxAge);
    String getCookie(String name, HttpServletRequest request);
    void removeCookie(String name, HttpServletRequest request, HttpServletResponse response);
}

