package trabajofinalpoo.users;

import trabajofinalpoo.CardBalance;

public class General {
    private String name, lastname, email, password;
    private CardBalance card;
    public General(String name, String lastname, String email, String password) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.card = new CardBalance();
    }

    public General(String name, String lastname, String email, String password, double balance) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.card = new CardBalance(balance);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CardBalance getCard() {
        return card;
    }

    public void setCard(CardBalance card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return  "name = '" + name + '\'' +
                ", lastname = '" + lastname + '\'' +
                ", email = '" + email + '\'' +
                ", password = '" + password + '\'' +
                ", card = " + card.getBalance();
    }
}
