package coffee.synyx.auth.oauth.user.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.ldap.userdetails.LdapUserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class SynyxUserDetails implements LdapUserDetails {

    private static final long serialVersionUID = 1L;

    private String mail;
    private LdapUserDetails details;

    public SynyxUserDetails(LdapUserDetails details) {

        this.details = details;
    }

    public String getMail() {

        return mail;
    }


    public void setMail(String mail) {

        this.mail = mail;
    }


    @Override
    public boolean isEnabled() {

        return details.isEnabled();
    }


    @Override
    @JsonIgnore
    public String getDn() {

        return details.getDn();
    }


    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return details.getAuthorities();
    }


    @JsonProperty("authorities")
    private List<String> getAuthoritiesAsStrings() {

        return new ArrayList<>(AuthorityUtils.authorityListToSet(details.getAuthorities()));
    }


    @Override
    @JsonIgnore
    public String getPassword() {

        return details.getPassword();
    }


    @Override
    public String getUsername() {

        return details.getUsername();
    }


    @Override
    public boolean isAccountNonExpired() {

        return details.isAccountNonExpired();
    }


    @Override
    public boolean isAccountNonLocked() {

        return details.isAccountNonLocked();
    }


    @Override
    public boolean isCredentialsNonExpired() {

        return details.isCredentialsNonExpired();
    }
}
