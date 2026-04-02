package vn.fpoly.java5.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements vn.fpoly.java5.utility.AuthService {

    private final CookieService cookieService;

    public AuthService(CookieService cookieService) {
        this.cookieService = cookieService;
    }

    @Override
    public void login(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        response.addCookie(cookieService.createCookie("username", username, 60 * 60 * 24));
    }

    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        cookieService.removeCookie("username", request, response);
    }

    @Override
    public boolean isLoggedIn(HttpServletRequest request) {
        return cookieService.getCookie("username", request) != null;
    }

    @Override
    public String getAccount(HttpServletRequest request) {
        return cookieService.getCookie("username", request);
    }
}
