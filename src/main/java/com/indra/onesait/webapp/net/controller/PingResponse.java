package com.indra.onesait.webapp.net.controller;

public class PingResponse {

    private String host;
    private String status;
    private String responseTime;

    public PingResponse(String host, String status, String responseTime) {
        this.host = host;
        this.status = status;
        this.responseTime = responseTime;
    }

    public String getHost() {
        return host;
    }

    public String getStatus() {
        return status;
    }

    public String getResponseTime() {
        return responseTime;
    }
}