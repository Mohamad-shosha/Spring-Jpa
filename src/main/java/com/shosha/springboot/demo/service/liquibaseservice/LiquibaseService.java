package com.shosha.springboot.demo.service.liquibaseservice;

import com.shosha.springboot.demo.error.exception.RollbackException;
import liquibase.Contexts;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Service
public class LiquibaseService {
    private final DataSource dataSource;

    @Autowired
    public LiquibaseService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void rollback(Integer changesToRollback) throws SQLException, LiquibaseException {
        Connection Connection = dataSource.getConnection();
        JdbcConnection jdbcConnection = new JdbcConnection(Connection);
        Database database = DatabaseFactory
                .getInstance()
                .findCorrectDatabaseImplementation(jdbcConnection);
        Liquibase liquibase = new Liquibase("db/changelog/db_master_changelog.xml", new ClassLoaderResourceAccessor(), database);
        liquibase.rollback(changesToRollback, new Contexts().toString());
    }

}
