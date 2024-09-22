package com.shosha.springboot.demo.controller.liquibasecontroller;

import com.shosha.springboot.demo.error.exception.RollbackException;
import com.shosha.springboot.demo.service.liquibaseservice.LiquibaseService;
import liquibase.exception.LiquibaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
@RequestMapping("liquibase")
public class LiquibaseController {
    private final LiquibaseService liquibaseService;

    @Autowired
    public LiquibaseController(LiquibaseService liquibaseService) {
        this.liquibaseService = liquibaseService;
    }

    @DeleteMapping("rollback/{ChangesToRollback}")
    public void rollback(@PathVariable Integer ChangesToRollback) throws SQLException, LiquibaseException {
        try {
            liquibaseService.rollback(ChangesToRollback);
        } catch (RollbackException e ) {
            throw new RollbackException(e.getMessage());
        }
    }

}
