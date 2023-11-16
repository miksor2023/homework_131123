package org.example;


public class Main {
    public static void main(String[] args) {
        try {
            chekAuthorizationData("yuioplkjhgfdsaz", "kjhgyguy", "kjhgyguy");
        } catch (WrongLoginException exception){
            System.out.println(exception);
        } catch (WrongPasswordException exception){
            System.out.println(exception);
        }
    }
    public static void chekAuthorizationData (String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException{
        if (!checkString(login) || login.isEmpty()){
            throw new WrongLoginException();
        }
        if (!checkString(password) || !password.equals(confirmPassword) || password.isEmpty()){
            throw new WrongPasswordException();
        }
    }
    public static boolean checkString(String string){// проверка строки: true - если удовлетворяет условиям
    Boolean result = string.matches("\\w{1,20}");
    return result;
    }

}