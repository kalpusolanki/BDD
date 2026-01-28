package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    Main(){
        System.out.println("COnstructor");
    }
    public static void main(String[] args) {

        Main mb = new Main();
    }
    {
        System.out.println("only block");
    }
}
