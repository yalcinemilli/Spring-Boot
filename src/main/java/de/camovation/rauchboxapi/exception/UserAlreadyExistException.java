package de.camovation.rauchboxapi.exception;


public class UserAlreadyExistException extends Exception {
   public UserAlreadyExistException() {
   }

   public UserAlreadyExistException(String message) {
      super(message);
   }

   public UserAlreadyExistException(String message, Throwable cause) {
      super(message, cause);
   }
}