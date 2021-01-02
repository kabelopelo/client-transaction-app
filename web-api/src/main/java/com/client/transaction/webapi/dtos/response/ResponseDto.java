package com.client.transaction.webapi.dtos.response;

import com.client.transaction.webapi.enums.RequestStatusEnum;

public class ResponseDto {

    private RequestStatusEnum requestStatusEnum;
    private String notes;

    public ResponseDto() {
    }

    public ResponseDto(RequestStatusEnum requestStatusEnum, String notes) {
        this.requestStatusEnum = requestStatusEnum;
        this.notes = notes;
    }

    public RequestStatusEnum getRequestStatusEnum() {
        return requestStatusEnum;
    }

    public void setRequestStatusEnum(RequestStatusEnum requestStatusEnum) {
        this.requestStatusEnum = requestStatusEnum;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
