package com.mycom.myboard.dto;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

public class BoardDto {
	
	private int boardId;
	private int UserSeq;
	private String userName;
	private String userProfileImageUrl;
	private String title;
	private String content;
	private LocalDateTime regDt;
	private int readCount;
	
	private boolean sameUser; // 게시글을 보는 user 와 작성한 user 가 같은지 여부
	
	private List<BoardFileDto> fileList; // 해당 게시글에 첨부된 파일 목록

	public BoardDto() {
		super();
	}

	public BoardDto(int userSeq, String title, String content) {
		super();
		UserSeq = userSeq;
		this.title = title;
		this.content = content;
	}

	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public int getUserSeq() {
		return UserSeq;
	}

	public void setUserSeq(int userSeq) {
		UserSeq = userSeq;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserProfileImageUrl() {
		return userProfileImageUrl;
	}

	public void setUserProfileImageUrl(String userProfileImageUrl) {
		
		if (userProfileImageUrl == null || "null".equals(userProfileImageUrl) || "".contentEquals(userProfileImageUrl)) {
			this.userProfileImageUrl = "/img/noProfile.png";
		} else {
			this.userProfileImageUrl = userProfileImageUrl;			
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getRegDt() {
		return regDt;
	}

	public void setRegDt(Date regDt) {
		// Mybatis가 LocalDateTime을 지원하지 않기 때문에 Date로 먼저 받아서 처리한다.( Mybatis Date Mapping )
		this.regDt = LocalDateTime.ofInstant(regDt.toInstant(), ZoneId.systemDefault());
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public boolean isSameUser() {
		return sameUser;
	}

	public void setSameUser(boolean sameUser) {
		this.sameUser = sameUser;
	}

	public List<BoardFileDto> getFileList() {
		return fileList;
	}

	public void setFileList(List<BoardFileDto> fileList) {
		this.fileList = fileList;
	}

	@Override
	public String toString() {
		return "BoardDto [boardId=" + boardId + ", UserSeq=" + UserSeq + ", userName=" + userName
				+ ", userProfileImageUrl=" + userProfileImageUrl + ", title=" + title + ", content=" + content
				+ ", regDt=" + regDt + ", readCount=" + readCount + ", sameUser=" + sameUser + ", fileList=" + fileList
				+ "]";
	}
	
}
