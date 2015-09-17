package org.sandbox.exception;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;

/**
 * Author: zhangxin
 * Date:   15-9-17
 */
public class ValidateObject {

    @NotEmpty
    private String id;

    @Size(min = 2, max = 6)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
