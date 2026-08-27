package com.resumeanalyzer.backend.controller;

import com.resumeanalyzer.backend.entity.Resume;
import com.resumeanalyzer.backend.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/resume")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping("/upload")
    public Resume uploadResume(
            @RequestParam("file") MultipartFile file,
            Authentication authentication
    ) throws IOException {

        String email = authentication.getName();

        return resumeService.uploadResume(file, email);
    }
}
