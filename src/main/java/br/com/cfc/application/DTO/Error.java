package br.com.cfc.application.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Error {
    private String code;
    private String message;
    private String description;
}