package com.example.pius_project.notFoundExceptions;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(long recordId){super("Record not found, id = " + recordId);}
}
