package com.publisher.steps;

public final class StepErrors {

    public static final String PAGE = "Page was not displayed";
    public static final String SITES = "Sites page was not displayed";
    public static final String PROJ = "Projects page was not displayed";
    public static final String DIM = "Browser was the wrong dimension";
    public static final String URL = "URL did not contain query";
    public static final String WIZARD = "Create Page wizard was not displayed";
    public static final String AUTH = "Login was not successful";
    public static final String DEAUTH = "Logout was not successful";
    public static final String LOGIN = "Login page was not displayed";
    public static final String TOKEN = "A login error message was displayed";

    private StepErrors(){ throw new AssertionError(); }


}
