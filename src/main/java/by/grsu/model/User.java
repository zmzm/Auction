package by.grsu.model;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User{

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    @ManyToOne
    @JoinColumn(name = "role_id")
    public Role role;
    @Column(name = "user_name")
    public String name;
    @Column(name = "user_password")
    public String password;

    public User(){};
}
