package com.example.machine_translaton_service.service;

import com.example.machine_translaton_service.exception.CustomException;
import com.example.machine_translaton_service.model.TranslateContent;
import com.example.machine_translaton_service.model.dto.TranslateContentDto;
import com.example.machine_translaton_service.repository.ContentDomainRepository;
import com.example.machine_translaton_service.repository.LangCodeRepository;
import com.example.machine_translaton_service.repository.TranslateContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TranslateContentServiceImpl implements TranslateContentService {


    private final TranslateContentRepository translateContentRepository;
    private final LangCodeRepository langCodeRepository;
    private final ContentDomainRepository contentDomainRepository;

    @Autowired
    public TranslateContentServiceImpl(TranslateContentRepository translateContentRepository,
                                       LangCodeRepository langCodeRepository,
                                       ContentDomainRepository contentDomainRepository
    ) {
        this.translateContentRepository = translateContentRepository;
        this.langCodeRepository = langCodeRepository;
        this.contentDomainRepository = contentDomainRepository;
    }


    public TranslateContent translateContent(TranslateContentDto translateContentDto) {
        TranslateContent translateCont = new TranslateContent();
        langCodeRepository.findByName(translateContentDto.getSourceLanguage())
                .orElseThrow(() -> new CustomException("Source language " + translateContentDto.getSourceLanguage() +
                        " does not exist!", HttpStatus.NOT_FOUND));
        langCodeRepository.findByName(translateContentDto.getTargetLanguage())
                .orElseThrow(() -> new CustomException("Target language " + translateContentDto.getTargetLanguage() +
                        " does not exist!", HttpStatus.NOT_FOUND));
        contentDomainRepository.findByDomain(translateContentDto.getDomain())
                .orElseThrow(() -> new CustomException("This domain does not exist!", HttpStatus.NOT_FOUND));

        translateCont.setSourceLanguage(translateContentDto.getSourceLanguage());
        translateCont.setTargetLanguage(translateContentDto.getTargetLanguage());
        translateCont.setDomain(translateContentDto.getDomain());
        translateCont.setContent(translateContentDto.getContent());
        return translateContentRepository.save(translateCont);
    }

    public TranslateContent validateTranslate(TranslateContentDto translateContentDto) {
        TranslateContent translateCont = new TranslateContent();
        langCodeRepository.findByName(translateContentDto.getSourceLanguage())
                .orElseThrow(() -> new CustomException("This name does not exist!", HttpStatus.BAD_REQUEST));
        langCodeRepository.findByName(translateContentDto.getTargetLanguage())
                .orElseThrow(() -> new CustomException("This name does not exist!", HttpStatus.BAD_REQUEST));
        contentDomainRepository.findByDomain(translateContentDto.getDomain())
                .orElseThrow(() -> new CustomException("This domain does not exist!", HttpStatus.BAD_REQUEST));

        String content = translateContentDto.getContent();
        if (!isValidContent(content)) {
            throw new CustomException("Content must have a maximum of 30 words!", HttpStatus.BAD_REQUEST);
        }

        translateCont.setSourceLanguage(translateContentDto.getSourceLanguage());
        translateCont.setTargetLanguage(translateContentDto.getTargetLanguage());
        translateCont.setDomain(translateContentDto.getDomain());
        translateCont.setContent(translateContentDto.getContent());
        return translateContentRepository.save(translateCont);
    }

    private boolean isValidContent(String content) {
        if (Objects.isNull(content)) {
            return false;
        }
        String[] words = content.split("\\s+");
        return words.length <= 30;
    }
}
