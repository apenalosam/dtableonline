package midknight.munch.dtable.repository;

import midknight.munch.dtable.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface UserRepository extends JpaRepository<User, String>{
    
    public abstract User findByUsername(String username);
    
    public abstract User findByUsernameAndPassword(String username, String password);
}
