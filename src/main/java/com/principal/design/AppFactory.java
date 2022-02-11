package com.principal.design;

public class AppFactory {
    public static App getAppInstance(String fileExtension){
        App appIn = null;
        if(fileExtension.equals(".doc")){
            appIn = new WordProcessor();
        }
        else if(fileExtension.equals(".txt")) {
            appIn = new TextEditor();
        }
        return appIn;
    }
}
