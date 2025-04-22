package org.example.springdata.persistence.entity;

import jakarta.persistence.*;
import org.example.springdata.enums.FileDownloadStatus;

@Entity
@Table(name = "file_info")
public class FileInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "file_url")
    private String fileUrl;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "file_path")
    private String filePath;

    @Column(name = "file_format")
    private String fileFormat;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "status")
    private FileDownloadStatus status;

    @Column(name = "error_message")
    private String errorMessage;
}
