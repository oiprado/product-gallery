/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perfiltic.oiprado.security.repository;

import com.perfiltic.oiprado.oauth.domain.UserAccount;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author oiprado
 */
@Repository
public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long> {

    public UserAccount findOneByUserName(String userName);

}
