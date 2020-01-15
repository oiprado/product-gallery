/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perfiltic.oiprado.oauth.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author oiprado
 */
@Entity
@Table(name = "user_account")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAccount.findAll", query = "SELECT u FROM UserAccount u")
    , @NamedQuery(name = "UserAccount.findById", query = "SELECT u FROM UserAccount u WHERE u.id = :id")
    , @NamedQuery(name = "UserAccount.findByAccountExpired", query = "SELECT u FROM UserAccount u WHERE u.accountExpired = :accountExpired")
    , @NamedQuery(name = "UserAccount.findByCreateDate", query = "SELECT u FROM UserAccount u WHERE u.createDate = :createDate")
    , @NamedQuery(name = "UserAccount.findByCredentialsExpired", query = "SELECT u FROM UserAccount u WHERE u.credentialsExpired = :credentialsExpired")
    , @NamedQuery(name = "UserAccount.findByCredentialsExpiredDate", query = "SELECT u FROM UserAccount u WHERE u.credentialsExpiredDate = :credentialsExpiredDate")
    , @NamedQuery(name = "UserAccount.findByEnabled", query = "SELECT u FROM UserAccount u WHERE u.enabled = :enabled")
    , @NamedQuery(name = "UserAccount.findByLocked", query = "SELECT u FROM UserAccount u WHERE u.locked = :locked")
    , @NamedQuery(name = "UserAccount.findByPassword", query = "SELECT u FROM UserAccount u WHERE u.password = :password")
    , @NamedQuery(name = "UserAccount.findByUserName", query = "SELECT u FROM UserAccount u WHERE u.userName = :userName")})
public class UserAccount implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "account_expired")
    private Boolean accountExpired;
    @Column(name = "create_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    @Column(name = "credentials_expired")
    private Boolean credentialsExpired;
    @Column(name = "credentials_expired_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date credentialsExpiredDate;
    @Column(name = "enabled")
    private Boolean enabled;
    @Column(name = "locked")
    private Boolean locked;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "user_name")
    private String userName;
    @JoinColumn(name = "user_info_id", referencedColumnName = "id")
    @OneToOne(optional = false)
    private SysUser userInfoId;

    public UserAccount() {
    }

    public UserAccount(Long id) {
        this.id = id;
    }

    public UserAccount(Long id, String password, String userName) {
        this.id = id;
        this.password = password;
        this.userName = userName;
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getCredentialsExpired() {
        return credentialsExpired;
    }

    public void setCredentialsExpired(Boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    public Date getCredentialsExpiredDate() {
        return credentialsExpiredDate;
    }

    public void setCredentialsExpiredDate(Date credentialsExpiredDate) {
        this.credentialsExpiredDate = credentialsExpiredDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
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

    public SysUser getUserInfoId() {
        return userInfoId;
    }

    public void setUserInfoId(SysUser userInfoId) {
        this.userInfoId = userInfoId;
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
        if (!(object instanceof UserAccount)) {
            return false;
        }
        UserAccount other = (UserAccount) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.perfiltic.oiprado.oauth.domain.UserAccount[ id=" + id + " ]";
    }
    
}
