package edu.neu.csye6200.Controller;


public class Routes {
    public void navigateTo(String page) {
        switch (page) {
            case "login":
                displayPage("web/view/login.jsp");
                break;
            case "dashboard":
                displayPage("web/view/dashboard.jsp");
                break;
            default:
                System.out.println("Page not found!");
        }
    }

    private void displayPage(String page) {
        System.out.println("Navigating to " + page);
    }
}