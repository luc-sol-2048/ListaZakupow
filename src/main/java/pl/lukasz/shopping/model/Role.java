package pl.lukasz.shopping.model;
import javax.persistence.*;



@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name="id_role")
    private int role =2;
    @Column(name="role_name")
    private String roleName = "user";

    public Role(int i, String user) {
        this.role = i;
        this.roleName=user;
    }

    public Role(){}


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

}
