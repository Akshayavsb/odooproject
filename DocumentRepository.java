package com.dayflow.repository;

import com.dayflow.entity.Document;
import com.dayflow.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentRepository
        extends JpaRepository<Document, Long> {

    // All documents of employee
    List<Document> findByEmployee(Employee employee);

    // Find documents by type
    List<Document> findByEmployeeAndDocumentType(
            Employee employee,
            String documentType
    );

    // Delete/find document by employee and type
    List<Document> findByDocumentType(String documentType);
}