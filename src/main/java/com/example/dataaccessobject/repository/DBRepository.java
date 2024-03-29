package com.example.dataaccessobject.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class DBRepository {
    private String query;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public DBRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        query = read("myScript.sql");
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getProductName(String name) {
        Map<String, Object> parametrs = new HashMap<>();
        parametrs.put("name", "alexey");

        List<String> productNames = namedParameterJdbcTemplate.queryForList(query, parametrs, String.class);

        return (!productNames.isEmpty() ? productNames.get(0) : null);
    }

}
