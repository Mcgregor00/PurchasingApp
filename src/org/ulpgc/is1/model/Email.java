package org.ulpgc.is1.model;

public class Email {
    private String account;
    private final String[] dominiosValidos;

    public Email(String account) {
        this.account = account;
        this.dominiosValidos = new String[]{"@gmail.com", "@hotmail.com", "@outlook.com"};
    }
    public boolean isValid() {
        for (String dominio : dominiosValidos) {
            if (account.endsWith(dominio)) {
                return true;
            }
        }
        return false;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}