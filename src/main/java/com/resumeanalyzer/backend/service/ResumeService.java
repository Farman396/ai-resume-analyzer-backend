package com.resumeanalyzer.backend.service;

import com.resumeanalyzer.backend.entity.Resume;
import com.resumeanalyzer.backend.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ResumeService {

    private final ResumeRepository resumeRepository;

    public Resume uploadResume(
            MultipartFile file,
            String email) throws IOException {

        PDDocument document =
                PDDocument.load(file.getInputStream());

        PDFTextStripper pdfStripper =
                new PDFTextStripper();

        String extractedText =
                pdfStripper.getText(document);

        document.close();

        Resume resume = Resume.builder()
                .fileName(file.getOriginalFilename())
                .extractedText(extractedText)
                .uploadedBy(email)
                .build();

        return resumeRepository.save(resume);
    }
}