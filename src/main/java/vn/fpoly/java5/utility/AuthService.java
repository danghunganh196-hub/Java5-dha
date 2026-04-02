package vn.fpoly.java5.utility;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthService {
    void login(String username, String password, HttpServletRequest request, HttpServletResponse response);
    void logout(HttpServletRequest request, HttpServletResponse response);
    boolean isLoggedIn(HttpServletRequest request);
    String getAccount(HttpServletRequest request);
}
