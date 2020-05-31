package edu.greenriver.it.securitypractice.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorityId;
    private String authority;

    @ManyToOne
    @JoinColumn(name="user")
    private User user;

    public Authority(String authority){
        this.authority = authority;
    }


    @Override
    public String getAuthority() {
        return null;
    }
}
