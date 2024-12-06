package id.sendistudio.spring.base.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import id.sendistudio.spring.base.data.responses.WebResponse;
import id.sendistudio.spring.base.services.HealthCheckService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Health Check")
@RequestMapping("/api/v1")
public class HealthCheckController {

    @Autowired
    HealthCheckService helloService;

    @GetMapping("/health-check")
    public ResponseEntity<WebResponse> healthCheck() {
        return ResponseEntity.ok(helloService.healthCheck());
    }

}