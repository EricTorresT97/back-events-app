import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PassEncypt {
    public static void main(String[] args) {
        BCryptPasswordEncoder b = new BCryptPasswordEncoder();
        System.out.println( b.encode("12345"));
    }
}
