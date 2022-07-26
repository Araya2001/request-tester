/*
 * Moovin Mensajería Express. Derechos Reservados (c) 2022
 * Creado por Alejandro Araya Jiménez alejandro.araya@moovin.me
 */

package aaj.requesttester.dto;

import org.springframework.http.HttpStatus;

public enum Status {
  SUCCESS("OK", "A-000", "SUCCESS", true, HttpStatus.OK),
  ERROR_INTERNAL("ERROR", "A-001", "INTERNAL ERROR", false, HttpStatus.INTERNAL_SERVER_ERROR),
  ERROR_BAD_REQUEST("ERROR", "A-002", "BAD REQUEST", false, HttpStatus.BAD_REQUEST),
  ERROR_DOCUMENT_NOT_FOUND("ERROR", "B-000", "No documents found for this user or endpoint", false, HttpStatus.BAD_REQUEST);
  private final String status;
  private final String code;
  private final String codeMessage;
  private final boolean result;
  private final HttpStatus httpStatus;

  Status(String status, String code, String codeMessage, boolean result, HttpStatus httpStatus) {
    this.status = status;
    this.code = code;
    this.codeMessage = codeMessage;
    this.result = result;
    this.httpStatus = httpStatus;
  }

  public String getCode() {
    return code;
  }

  public String getCodeMessage() {
    return codeMessage;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public String getStatus() {
    return status;
  }

  public boolean isResult() {
    return result;
  }
}
