package midknight.munch.dtable.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;
import midknight.munch.dtable.util.Util;
/**
 *
 * @author Andres Peñalosa
 */
@Entity
@Table(name = "users", schema="dynamic_dnd")
public class User implements Serializable{
    @Id
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="users_names")
    private String names;
    @Column(name="last_names")
    private String lastNames;

    public User() {
    }

    public User(HttpServletRequest request) {
        this.username = Util.decode(request.getParameter("username"));
        this.password = Util.decode(request.getParameter("password"));
        this.names = Util.decode(request.getParameter("names"));
        this.lastNames = Util.decode(request.getParameter("lastNames"));
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }
    
}
