/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perfiltic.oiprado.oauth.domain;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oiprado
 */
@Entity
@Table(name = "sys_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SysUser.findAll", query = "SELECT s FROM SysUser s")
    , @NamedQuery(name = "SysUser.findById", query = "SELECT s FROM SysUser s WHERE s.id = :id")
    , @NamedQuery(name = "SysUser.findByAccountExpired", query = "SELECT s FROM SysUser s WHERE s.accountExpired = :accountExpired")
    , @NamedQuery(name = "SysUser.findByAccountLocked", query = "SELECT s FROM SysUser s WHERE s.accountLocked = :accountLocked")
    , @NamedQuery(name = "SysUser.findByCredentialsExpired", query = "SELECT s FROM SysUser s WHERE s.credentialsExpired = :credentialsExpired")
    , @NamedQuery(name = "SysUser.findByEnabled", query = "SELECT s FROM SysUser s WHERE s.enabled = :enabled")
    , @NamedQuery(name = "SysUser.findByPassword", query = "SELECT s FROM SysUser s WHERE s.password = :password")
    , @NamedQuery(name = "SysUser.findByUserName", query = "SELECT s FROM SysUser s WHERE s.userName = :userName")
    , @NamedQuery(name = "SysUser.findByGuid", query = "SELECT s FROM SysUser s WHERE s.guid = :guid")
    , @NamedQuery(name = "SysUser.findByMail", query = "SELECT s FROM SysUser s WHERE s.mail = :mail")
    , @NamedQuery(name = "SysUser.findByName", query = "SELECT s FROM SysUser s WHERE s.name = :name")
    , @NamedQuery(name = "SysUser.findBySureName", query = "SELECT s FROM SysUser s WHERE s.sureName = :sureName")
    , @NamedQuery(name = "SysUser.findByAddress", query = "SELECT s FROM SysUser s WHERE s.address = :address")})
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "account_expired")
    private Boolean accountExpired;
    @Column(name = "account_locked")
    private Boolean accountLocked;
    @Column(name = "credentials_expired")
    private Boolean credentialsExpired;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "password")
    private String password;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "guid")
    private String guid;
    @Column(name = "mail")
    private String mail;
    @Column(name = "name")
    private String name;
    @Column(name = "sure_name")
    private String sureName;
    @Column(name = "address")
    private String address;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userInfoId")
    private UserAccount userAccount;

    public SysUser() {
    }

    public SysUser(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(Boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    public Boolean getAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(Boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public Boolean getCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(Boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SysUser)) {
            return false;
        }
        SysUser other = (SysUser) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.perfiltic.oiprado.oauth.domain.SysUser[ id=" + id + " ]";
    }
    
}
