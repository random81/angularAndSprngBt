package com.demo.spBtInventory.domain.exception;

public class ResourceNotFoundException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(Long id) {
        super("Could not find item with id " + id + ".");
    }
}
