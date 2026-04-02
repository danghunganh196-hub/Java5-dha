package vn.fpoly.java5.utility;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

public interface AuthService {
String getUserName();
List<String> getRoles();
Boolean isAuthenticated();
Boolean hasAnyRole(String ...roles);
}
