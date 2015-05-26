/*
 * Copyright 2015 Pawan Dubey pawandubey@outlook.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pawandubey.diurna.control;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import spark.ResponseTransformer;
import static spark.Spark.after;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;
import spark.servlet.SparkApplication;
/**
 *
 * @author Pawan Dubey pawandubey@outlook.com
 */
public class DiurnaMainController implements SparkApplication {
    private DiurnaDataService service;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    @Override
    public void init() {
        try {
            service = new DiurnaDataService("diurna", USERNAME, PASSWORD);

            get("/users", (req, res) -> service.getAllUsers(), new JsonTransformer());

            get("/users/:id", (req, res) -> service.getUser(req.params(":id")), new JsonTransformer());

            post("/users", (req, res) -> service.createUser(req.queryParams("name")), new JsonTransformer());

            get("/users/:id/notes", (req, res) -> service.getAllNotes(req.params(":id")), new JsonTransformer());

            get("/users/:id/notes/:noteid", (req, res) -> service.getNote(req.params(":noteid")), new JsonTransformer());

            post("/users/:id/notes", (req, res) -> service.createNote(req.queryParams("title"), req.queryParams("content"), req.params(":id")), new JsonTransformer());

            put("/users/:id/notes/:noteid", (req, res) -> service.updateNote(req.params(":id"), req.queryParams("title"), req.queryParams("content")), new JsonTransformer());

            delete("/users/:id/notes/:noteid", (req, res) -> service.deleteNote(req.params(":noteid")), new JsonTransformer());

            after((req, res) -> {
                res.type("application/json");
            });
        }
        catch (SQLException ex) {
            System.out.println("Exception occured : ");
            System.out.println(ex.getMessage());
            Logger.getLogger(DiurnaMainController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static class JsonTransformer implements ResponseTransformer {

        @Override
        public String render(Object o) throws Exception {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return gson.toJson(o);
        }
    }

}
