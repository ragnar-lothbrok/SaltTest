package com.salttest.model;

import java.io.Serializable;

public class BirdBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String $schema;
    private String title;
    private String description;
    private Boolean additionalProperties;
    private Properties properties;

    public String get$schema() {
        return $schema;
    }

    public void set$schema(String $schema) {
        this.$schema = $schema;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Boolean additionalProperties) {
        this.additionalProperties = additionalProperties;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "BirdBean [$schema=" + $schema + ", title=" + title + ", description=" + description
                + ", additionalProperties=" + additionalProperties + ", properties=" + properties + "]";
    }

}
