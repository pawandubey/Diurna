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

import com.pawandubey.diurna.api.Diurna;
import com.pawandubey.diurna.model.Note;
import com.pawandubey.diurna.model.ToDo;
import com.pawandubey.diurna.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pawan Dubey pawandubey@outlook.com
 */
public class DiurnaDataService implements Diurna {

    private final Connection connection;
    private Statement statement;
    private final String dbUserName;
    private final String dbUserPassword;
    private final String dbName;
    private String query;

    public DiurnaDataService(String db, String user, String pass) throws SQLException {
        this.dbName = db;
        this.dbUserName = user;
        this.dbUserPassword = pass;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException ex) {
            Logger.getLogger(DiurnaDataService.class.getName()).log(Level.SEVERE, null, ex);
        }
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, user, pass);
        if (connection.isValid(5)) {
            System.out.println("Connection works");
        }
        else {
            System.out.println("Doesnt work");
        }
        statement = connection.createStatement();
    }

    @Override
    public User getUser(String id) throws SQLException {
        query = "SELECT * FROM user WHERE id = ?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setInt(1, Integer.parseInt(id));
        ps.executeQuery();
        ResultSet rs = ps.getResultSet();
        if (rs.next()) {
            User user = new User(String.valueOf(rs.getInt("id")), rs.getString("name"));
            ps.close();
            return user;
        }
        else {
            return null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean createUser(String name) throws SQLException {
        query = "INSERT INTO user(name) VALUES(?)";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, name);
        try {
            ps.executeUpdate();
        }
        catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean createNote(String id, String title, String content, String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Note getNote(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Note> getAllNotes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean updateNote(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean deleteNote(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean createToDo(String id, String title, String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ToDo getToDo(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ToDo> getAllToDos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean updateToDo(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean deleteToDo(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
