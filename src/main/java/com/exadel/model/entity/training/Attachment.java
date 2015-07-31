package com.exadel.model.entity.training;

import com.exadel.dto.AttachmentDTO;

import javax.persistence.*;

@Entity
@Table(name = "attachments")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String type;
    private String name;
    private String link;

    @ManyToOne
    @JoinColumn(name = "entry_id", nullable = false)
    private Entry entry;

    public Attachment() {
    }

    public Attachment(AttachmentDTO attachmentDTO) {
        this.id = attachmentDTO.getId();
        this.type = attachmentDTO.getType();
        this.name = attachmentDTO.getName();
        this.link = attachmentDTO.getLink();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Entry getEntry() {
        return entry;
    }

    public void setEntry(Entry entry) {
        this.entry = entry;
    }
}
