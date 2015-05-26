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
package com.pawandubey.diurna.api;

import com.pawandubey.diurna.model.Note;
import com.pawandubey.diurna.model.ToDo;
import com.pawandubey.diurna.model.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Pawan Dubey pawandubey@outlook.com
 */
public interface Diurna {

    public User getUser(String id) throws SQLException;

    public List<User> getAllUsers() throws SQLException;

    public Boolean createUser(String name) throws SQLException;

    public Boolean createNote(String id, String title, String content, String userId) throws SQLException;

    public Note getNote(String id) throws SQLException;

    public List<Note> getAllNotes() throws SQLException;

    public Boolean updateNote(String id) throws SQLException;

    public Boolean deleteNote(String id) throws SQLException;

    public Boolean createToDo(String id, String title, String userId) throws SQLException;

    public ToDo getToDo(String id) throws SQLException;

    public List<ToDo> getAllToDos() throws SQLException;

    public Boolean updateToDo(String id) throws SQLException;

    public Boolean deleteToDo(String id) throws SQLException;
}
