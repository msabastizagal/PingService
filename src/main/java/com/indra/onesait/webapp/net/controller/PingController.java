package com.indra.onesait.webapp.net.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
@RestController
@RequestMapping("/api")
public class PingController {

    @GetMapping("/ping")
    public ResponseEntity<PingResponse> pingIp(@RequestParam String host) {
        try {
            long startTime = System.currentTimeMillis();
            InetAddress address = InetAddress.getByName(host);
            boolean reachable = address.isReachable(3000);
            long endTime = System.currentTimeMillis();

            if (reachable) {
                return ResponseEntity.ok(
                        new PingResponse(host, "Success", (endTime - startTime) + "ms")
                );
            } else {
                return ResponseEntity.status(504)
                        .body(new PingResponse(host, "Unreachable", null));
            }
        } catch (Exception e) {
            return ResponseEntity.status(400)
                    .body(new PingResponse(host, "Error: " + e.getMessage(), null));
        }
    }
}