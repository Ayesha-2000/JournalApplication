package com.entry;

import java.time.LocalDateTime;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.lang.NonNull;

import lombok.Data;
@Document
@Data
public class JournalEntry {
	@Id
private String id;
	@NonNull
private String title;
private String content;
private LocalDateTime date;
}
