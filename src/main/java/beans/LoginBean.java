package beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.Query;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Named("loginBean")
@RequestScoped
@Data @NoArgsConstructor @AllArgsConstructor
public class LoginBean{
    private String email;
    private String password;
    private String role;
}