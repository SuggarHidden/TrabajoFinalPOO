package trabajofinalpoo.users;

import trabajofinalpoo.Card;

public abstract class Usuario {
    private String name, lastname, email, password;
    private Card card;
    public Usuario(String name, String lastname, String email, String password) {
            this.name = name;
            this.lastname = lastname;
            this.email = email;
            this.password = password;
        }
    public Usuario(String name, String lastname, String email, String password, double balance) {
      this(name, lastname, email, password);
        this.card = new Card(balance);
    }

    @Override
    public String toString() {
        return  "name = '" + name + '\'' +
                ", lastname = '" + lastname + '\'' +
                ", email = '" + email + '\'' +
                ", password = '" + password + '\'' +
                ", card = " + card.getBalance();
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

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
