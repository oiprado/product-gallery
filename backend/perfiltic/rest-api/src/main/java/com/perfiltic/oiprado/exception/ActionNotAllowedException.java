/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perfiltic.oiprado.exception;

/**
 *
 * @author oiprado
 */
public class ActionNotAllowedException extends RuntimeException{

    public ActionNotAllowedException(String message) {
        super(message);
    }
    
}
