package uz.bakhodirov.census.session;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import uz.bakhodirov.census.entity.auth.AuthUser;
import uz.bakhodirov.census.enums.Role;
import uz.bakhodirov.census.repository.auth.AuthUserRepository;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SessionUser {

    private final AuthUserRepository repository;


    public String getUsername() {
        return (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public Long getId() {
        Optional<AuthUser> user = repository.findByUsernameAndDeletedFalse(this.getUsername());
        return user.get().getId();
    }

    public Role getRole(){
        Optional<AuthUser> user = repository.findByUsernameAndDeletedFalse(this.getUsername());
        return user.get().getRole();
    }




}
