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
package com.pawandubey.diurna.model;

/**
 *
 * @author Pawan Dubey pawandubey@outlook.com
 */
public class Note {
    private String title;
    private String content;
    private String dateCreated;
    private final String userId;
    private final String id;

    public Note(String id, String title, String content, String userId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    public void setDateCreated(String date) {
        this.dateCreated = date;
    }

    public String getDateCreated() {
        return this.dateCreated;
    }
}
