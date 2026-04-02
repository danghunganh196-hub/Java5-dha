package vn.fpoly.java5.utility;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface CookieService {
    Cookie createCookie(String name, String value, int expiry);
    Cookie getCookie(String name);
    String getCookieByValue(String name);
    void deleteCookie(String name);
}

