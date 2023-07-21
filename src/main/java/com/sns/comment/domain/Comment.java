package com.sns.comment.domain;

import java.time.ZonedDateTime;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Comment {
	private int id;
	private int postId;
	private int userId;
	private int content;
	private ZonedDateTime createdAt;
	private ZonedDateTime updatedAt;
}
