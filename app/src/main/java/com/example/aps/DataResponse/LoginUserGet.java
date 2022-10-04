package com.example.aps.DataResponse;

import java.io.Serializable;

public class LoginUserGet implements Serializable {
    private int status;
    private String token;
    private String routing_level;
    private String org_id;

    public LoginUserGet(String token) {
        this.token = token;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRouting_level() {
        return routing_level;
    }

    public void setRouting_level(String routing_level) {
        this.routing_level = routing_level;
    }

    public String getOrg_id() {
        return org_id;
    }

    public void setOrg_id(String org_id) {
        this.org_id = org_id;
    }
}
