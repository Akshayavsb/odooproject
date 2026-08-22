package com.dayflow.hrms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/documents")
@CrossOrigin(origins = "http://localhost:3000")
public class DocumentController {

    // Upload document
    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocument(
            @RequestParam("file") MultipartFile file,
            @RequestParam("employeeId") Long employeeId) {

        if (file.isEmpty()) {
            return ResponseEntity.badRequest()
                    .body("Please select a document to upload");
        }

        // Document upload logic will be connected to DocumentService
        return ResponseEntity.ok("Document uploaded successfully");
    }

    // Get documents of an employee
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<String> getEmployeeDocuments(
            @PathVariable Long employeeId) {

        // Logic will be connected to DocumentService
        return ResponseEntity.ok(
                "Documents for employee ID: " + employeeId);
    }

    // Download document
    @GetMapping("/download/{documentId}")
    public ResponseEntity<String> downloadDocument(
            @PathVariable Long documentId) {

        // Download logic will be connected to DocumentService
        return ResponseEntity.ok(
                "Download document ID: " + documentId);
    }

    // Delete document
    @DeleteMapping("/{documentId}")
    public ResponseEntity<String> deleteDocument(
            @PathVariable Long documentId) {

        // Delete logic will be connected to DocumentService
        return ResponseEntity.ok(
                "Document deleted successfully");
    }
}