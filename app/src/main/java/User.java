public class User {


    public User currentUser;


    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "currentUser=" + currentUser +
                '}';
    }

    public User(User currentUser) {
        this.currentUser = currentUser;
    }
}
