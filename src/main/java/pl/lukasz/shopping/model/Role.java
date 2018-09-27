package pl.lukasz.shopping.model;
import javax.persistence.*;



@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name="id_role")
    private int role;
    @Column(name="role_name")
    private String roleName;



    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

//    public Set<User> getUsers() {
//        return users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
}
