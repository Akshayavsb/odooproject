package com.dayflow.hrms.service;

import com.dayflow.hrms.entity.Document;
import com.dayflow.hrms.repository.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    private final DocumentRepository documentRepository;

    public DocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    // Get all documents
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    // Get document by ID
    public Optional<Document> getDocumentById(Long id) {
        return documentRepository.findById(id);
    }

    // Get documents of an employee
    public List<Document> getEmployeeDocuments(Long employeeId) {
        return documentRepository.findByEmployeeId(employeeId);
    }

    // Add document
    public Document addDocument(Document document) {
        return documentRepository.save(document);
    }

    // Update document
    public Document updateDocument(Long id, Document updatedDocument) {

        Document document = documentRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Document not found"));

        document.setDocumentName(updatedDocument.getDocumentName());
        document.setDocumentType(updatedDocument.getDocumentType());
        document.setDocumentUrl(updatedDocument.getDocumentUrl());

        return documentRepository.save(document);
    }

    // Delete document
    public void deleteDocument(Long id) {

        if (!documentRepository.existsById(id)) {
            throw new RuntimeException("Document not found");
        }

        documentRepository.deleteById(id);
    }
}