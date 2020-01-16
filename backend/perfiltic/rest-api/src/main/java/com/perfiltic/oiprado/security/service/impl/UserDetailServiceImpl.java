/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perfiltic.oiprado.security.service.impl;

import com.perfiltic.oiprado.oauth.domain.UserAccount;
import com.perfiltic.oiprado.security.repository.UserAccountRepository;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserAccountRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserAccount user = userRepository.findOneByUserName(userName);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", userName));
        }

        return new UserRepositoryUserDetails(user);
    }

    private final static class UserRepositoryUserDetails implements UserDetails {

        private static final long serialVersionUID = 1L;

        protected Collection<SimpleGrantedAuthority> authorities;
        protected String environment;
        protected UserAccount user;

        private UserRepositoryUserDetails(UserAccount user) {
            this.user = user;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return authorities;
        }

        public String getEnvironment() {
            return environment;
        }

        public void setEnvironment(String environment) {
            this.environment = environment;
        }

        @Override
        public String getUsername() {
            return this.user.getUserName();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        @Override
        public String getPassword() {
            return this.user.getPassword();
        }

        @Override
        public String toString() {
            return String.format("[userName] = %s", getUsername());
        }

    }

}
