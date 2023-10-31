package com.global.advanced.java.advancedjava;

import com.global.advanced.java.advancedjava.cdr.Cdr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICdrDao extends JpaRepository<Cdr,String> {

}
