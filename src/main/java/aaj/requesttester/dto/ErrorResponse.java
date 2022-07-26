package aaj.requesttester.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.io.Serializable;

public class ErrorResponse extends Response implements Serializable {
  @JsonAlias("Error")
  Error error;

  public Error getError() {
    return error;
  }

  public void setError(Error error) {
    this.error = error;
  }
}
