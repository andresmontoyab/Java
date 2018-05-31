package finalStatement;

public final class Password {


    private static final int KEY = 786146456;
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encrypDecryp(password);
    }


    public int encrypDecryp(int password) {
        return password ^ KEY;
    }

    public final void storePassword() {
        System.out.println("Saving password as " + this.encryptedPassword);
    }

    public boolean letMeIn(int password) {
        if (encrypDecryp(password) == this.encryptedPassword) {
            System.out.println("Welcome");
            return true;
        } else {
            System.out.println("Nope, you can not come in.");
            return false;
        }
    }
}
