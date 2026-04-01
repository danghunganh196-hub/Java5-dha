//package vn.fpoly.java5.utility;
//
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//public interface CookieService {
//    public Cookie createCookie(String name, String value, Integer maxAge) {
//        Cookie cookie = new Cookie(name, value);
//        cookie.setMaxAge(maxAge);
//        cookie.setPath("/");
//        return cookie;
//    }
//    public String getCookie(String name, HttpServletRequest request) {
//        if(request.getCookies() != null) {
//            for (Cookie cookie : request.getCookies()) {
//                if (cookie.getName().equals(name)) {
//                    return cookie.getValue();
//                }
//            }
//        }
//        return null;
//    }
//    public void removeCookie(String name, HttpServletRequest request, HttpServletResponse response) {
//        if (request.getCookies() != null) {
//            for (Cookie cookie : request.getCookies()) {
//                if (cookie.getName().equals(name)) {
//                    cookie.setMaxAge(0);
//                    cookie.setPath("/");
//                    response.addCookie(cookie);
//                }
//            }
//        }
//    }
//}
//
