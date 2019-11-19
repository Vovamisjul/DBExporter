package com.vovamisjul;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Validator {
    protected static final Logger logger = LogManager.getLogger(Validator.class);
    private static JSONObject jsonSchema = new JSONObject(
            new JSONTokener(Validator.class.getResourceAsStream("/schema.json")));

    public static void check(String json) {
        JSONObject jsonSubject = new JSONObject(
            new JSONTokener(json));
        logger.info("Checking json");
        Schema schema = SchemaLoader.load(jsonSchema);
        schema.validate(jsonSubject);
        logger.info("json valid");
    }

}
