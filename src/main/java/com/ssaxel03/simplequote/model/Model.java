package com.ssaxel03.simplequote.model;

/**
 * Common interface for a model, provides methods to get and set ids
 */
public interface Model {

    /**
     * Gets the model id
     *
     * @return the model id
     */
    Long getId();

    /**
     * Sets the model id
     *
     * @param id the id to set
     */
    void setId(Long id);
}
