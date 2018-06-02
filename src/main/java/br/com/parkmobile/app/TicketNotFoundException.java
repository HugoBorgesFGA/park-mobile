package br.com.parkmobile.app;

public class TicketNotFoundException extends Exception {

    private String description;

    public TicketNotFoundException(final String description){

        this.description = description;
    }
}
