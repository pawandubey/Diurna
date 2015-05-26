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
import java.util.List;

/**
 *
 * @author Pawan Dubey pawandubey@outlook.com
 */
public interface Diurna {

    public User getUser(String id);

    public List<User> getAllUsers();

    public Boolean createUser(String id, String name);

    public Boolean createNote(String id, String title, String content, String userId);

    public Note getNote(String id);

    public List<Note> getAllNotes();

    public Boolean updateNote(String id);

    public Boolean deleteNote(String id);

    public Boolean createToDo(String id, String title, String userId);

    public ToDo getToDo(String id);

    public List<ToDo> getAllToDos();

    public Boolean updateToDo(String id);

    public Boolean deleteToDo(String id);
}
