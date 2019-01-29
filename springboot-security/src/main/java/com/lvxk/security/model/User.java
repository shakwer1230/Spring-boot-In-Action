package com.lvxk.security.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @
 * @Author:lvxiaoke
 * @Date: 2019/1/15
 * @
 */
@Table(name = "t_user")
@Entity
@Data
public class User implements Serializable,UserDetails{
    @Id
    @Column(name = "userId")
    public Long userId;

    @Column(name = "userName")
    public String userName;

    @Column(name = "userPassword")
    public String userPassWord;

    @Column(name = "userEmail")
    public String email;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = {
                    @JoinColumn(name = "user_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id")
            }
    )
    public List<Role> roles;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority>auths=new ArrayList<>();
        List<Role> roles=getRoles();
        for(Role role :roles){
            auths.add(new SimpleGrantedAuthority(role.getName()));
        }
        return auths;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
