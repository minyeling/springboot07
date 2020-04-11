package school.minyeling.controller;

import java.io.File;

public class Test {

    public static void main(String[] args) {
        File file=new File("./src/main/java/school/minyeling/controller");
        String[] list = file.list();
        for(String s:list){
            System.out.println(s);
        }
        System.out.println("=====");
        System.out.println(file.getPath());
    }

}
