package aaj.requesttester.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

import java.io.Serializable;

public class Error implements Serializable {
  public Error(Status status) {
    this.code = status.getCode();
    this.info = status.getCodeMessage();
  }

  @JsonAlias("Code")
  String code;
  @JsonAlias("Info")
  String info;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }
}
