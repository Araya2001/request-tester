package aaj.requesttester.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.io.Serializable;



public abstract class Response implements Serializable {
  @JsonAlias("Status")
  String status;
  @JsonAlias("Message")
  String message;

  @JsonAlias("Result")
  boolean result;

  public boolean isResult() {
    return result;
  }

  public void setResult(boolean result) {
    this.result = result;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public String toString() {
    return "Response{" +
        "status='" + status + '\'' +
        ", message='" + message + '\'' +
        ", result=" + result +
        '}';
  }
}
