/**
 * Reus
 * Copyright (C), 2011 - 2018, Reus.
 */
package com.reus.domain;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @version $Id: ResultItems.java, v 0.1 2018-09-18 reus Exp $
 * @ClassName: ResultItems
 * @Description:
 * @author: reus
 */
public class ResultItems {

    private Map<String, Object> fields = new LinkedHashMap<String, Object>();

    private Request request;

    public <T> T get(String key) {
        Object o = fields.get(key);
        if (o == null) {
            return null;
        }
        return (T) fields.get(key);
    }

    public Map<String, Object> getAll() {
        return fields;
    }

    public <T> ResultItems put(String key, T value) {
        fields.put(key, value);
        return this;
    }

    public Request getRequest() {
        return request;
    }

    public ResultItems setRequest(Request request) {
        this.request = request;
        return this;
    }

}