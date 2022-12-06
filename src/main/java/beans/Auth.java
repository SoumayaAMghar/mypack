package beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;

import java.io.Serializable;

@SessionScoped
public class Auth  implements Serializable{
    public void login() throws Exception {
        System.out.println("hello Looogin");

    }
}
