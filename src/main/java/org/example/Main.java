package org.example;


public class Main {
    public static void main(String[] args) {
        try {
            chekAuthorizationData("werR%___", "kjhgyguy", "kjhgyguy");
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
        if (string.length() > 20) {
            return false;
        }
        String allowedSymbols = "0123456789abcdefghijklmnoprstuvwxyz_";
        string = string.toLowerCase();
        for (int i = 0; i < string.length(); i++) {
            Boolean forbiddenSymbol = true;
            for (int j = 0; j < allowedSymbols.length(); j++) {
                if(string.charAt(i) == allowedSymbols.charAt(j)){
                    forbiddenSymbol = false;
                }
            }
            if(forbiddenSymbol){
                return false;
            }
        }
        return true;
    }

}