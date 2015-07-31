package com.exadel.controller;

import com.exadel.dto.AttachmentDTO;
import com.exadel.dto.EntryDTO;
import com.exadel.model.entity.feedback.TrainingFeedback;
import com.exadel.model.entity.training.Attachment;
import com.exadel.model.entity.training.Entry;
import com.exadel.model.entity.training.Training;
import com.exadel.model.entity.user.User;
import com.exadel.service.EntryService;
import com.exadel.service.TrainingFeedbackService;
import com.exadel.service.TrainingService;
import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/entry")
public class EntryController {
    @Autowired
    private EntryService entryService;

    @RequestMapping(value = "attachments", method = RequestMethod.GET)
    public List<AttachmentDTO> getAttachments(@RequestParam String id) {
        Entry entry = entryService.getEntryById(id);
        List<Attachment> attachments = entry.getAttachments();
        List<AttachmentDTO> attachmentDTOs = new ArrayList<>();

        for (Attachment attachment : attachments) {
            attachmentDTOs.add(new AttachmentDTO(attachment));
        }
        return attachmentDTOs;
    }

    @RequestMapping(value = "attachments", method = RequestMethod.POST)
    public void getAttachments(@RequestBody  AttachmentDTO attachmentDTO) {
        Attachment attachment = new Attachment(attachmentDTO);
        attachment.setEntry(entryService.getEntryById(attachmentDTO.getEntryId()));

    }

    @RequestMapping(method = RequestMethod.GET)
    public EntryDTO getEntry(@RequestParam String entryId) {
        Entry entry = entryService.getEntryById(entryId);
        return new EntryDTO(entry);
    }
}
