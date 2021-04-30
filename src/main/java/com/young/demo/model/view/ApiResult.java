package com.young.demo.model.view;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.JsonObject;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class ApiResult<T> {
    private T data;
    private JsonObject meta;

    public ApiResult(T data) {
        this.data = data;
    }

    public static <T> ApiResult<T> apiResult(T data) {
        return new ApiResult<>(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public JsonObject getMeta() {
        return meta;
    }

    public void setMeta(JsonObject meta) {
        this.meta = meta;
    }
}
