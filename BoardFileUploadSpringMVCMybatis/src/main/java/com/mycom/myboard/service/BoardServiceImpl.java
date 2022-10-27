package com.mycom.myboard.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mycom.myboard.dao.BoardDao;
import com.mycom.myboard.dto.BoardDto;
import com.mycom.myboard.dto.BoardFileDto;
import com.mycom.myboard.dto.BoardParamDto;
import com.mycom.myboard.dto.BoardResultDto;

// Controller 의 요청에 의해 필요한 파라미터는 받고, 원하는 결과 데이터를 만들어서 리턴해 준다.
// Business Logic 의 핵심은 바로 Service layer에서!!!!
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao dao;

	private final int SUCCESS = 1;
	private final int FAIL = -1;
	
	// C:\Users\SSAFY\Documents\SPRING-BASIC\BoardFileUploadSpringMVCMybatis\src\main\webapp\resources\static
	private final String uploadPath="C:"+File.separator+
			"Users"+File.separator+"SSAFY"+File.separator+"Documents"+File.separator+"SPRING-BASIC"+File.separator
			+"BoardFileUploadSpringMVCMybatis"+File.separator+"src"+File.separator+"main"+File.separator+"webapp"
			+File.separator+"resources"+File.separator+"static";
	
	private final String uploadFolder="upload";
	
	@Override
	public BoardResultDto boardList(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		try {
			// 목록, 총건수 를 가져온다.
			List<BoardDto> list = dao.boardList(boardParamDto);
			int count = dao.boardListTotalCount();
			boardResultDto.setList(list);
			boardResultDto.setCount(count);
			boardResultDto.setResult(SUCCESS);
		} catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		
		return boardResultDto;
	}

	@Override
	public BoardResultDto boardListSearchWord(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		try {
			// 목록, 총건수 를 가져온다.
			List<BoardDto> list = dao.boardListSearchWord(boardParamDto);
			int count = dao.boardListSearchWordTotalCount(boardParamDto);
			boardResultDto.setList(list);
			boardResultDto.setCount(count);
			boardResultDto.setResult(SUCCESS);
		} catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		
		return boardResultDto;
	}

	@Override
	public BoardResultDto boardDetail(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		try {
			// DB 에서 게시글 정보를 가져온다.
			BoardDto boardDto = dao.boardDetail(boardParamDto);
			// 게시글 작성자와 현재 상세 조회하는 사용자의 동일인 여부 확인
			if (boardDto.getUserSeq() == boardParamDto.getUserSeq()) {
				boardDto.setSameUser(true);
			} else {
				boardDto.setSameUser(false);
			}
			// boardResultDto 의 일부인 boardDto 를 설정
			boardResultDto.setDto(boardDto);
			boardResultDto.setResult(SUCCESS);
			
		} catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		
		return boardResultDto;
	}

	@Override
	public BoardResultDto boardUpdate(BoardDto boardDto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		try {
			// DB 에서 게시글 정보를 가져온다.
			int ret = dao.boardUpdate(boardDto); // update 되는 건수
			
			
			if (ret == 1) {
				boardResultDto.setResult(SUCCESS);
			} else {
				boardResultDto.setResult(FAIL);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		
		return boardResultDto;
	}

	@Override
	public BoardResultDto boardDelete(int boardId) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		try {
			// DB 에서 게시글 정보를 가져온다.
			int ret = dao.boardDelete(boardId); // 삭제 되는 건수
			if (ret == 1) {
				boardResultDto.setResult(SUCCESS);
			} else {
				boardResultDto.setResult(FAIL);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		
		return boardResultDto;
	}

	@Override
	public BoardResultDto boardInsert(BoardDto dto, MultipartHttpServletRequest request) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		// 게시글 테이블에 등록
		// 물리적인 파일 저장
		// 여러 개의 파일이 기본
		// Multipart의 각 파트별로 파일을 구분해서 물리적으로 저장 => 파일 업로드 정보를 테이블에 저장
		
		try {
			int ret = dao.boardInsert(dto);
			//System.out.println(dto);
			//System.out.println("generated key : " + dto.getBoardId());
			
			
			File uploadDir=new File(uploadPath + File.separator + uploadFolder); // 업로드 파일이 저장될 폴더 (디렉토리)
			if (!uploadDir.exists()) uploadDir.mkdir(); // 없으면 새로 생성
			
			List<MultipartFile> fileList=request.getFiles("file");
			for (MultipartFile partFile : fileList) {
				int boardId=dto.getBoardId();	// 이전 등록된 게시글의 key
				String fileName=partFile.getOriginalFilename(); 	// 이 이름으로는 바로 저장하지 않고, UUID를 이용해서 중복 불가한 파일 이름을 만듦
				
				// Random UUID File id
				UUID uuid=UUID.randomUUID(); //대체할 파일 이름
				
				String extension=FilenameUtils.getExtension(fileName); 	//파일 확장자만 추출
				
				// 실제 저장할 파일 전체 이름
				String savingFileName = uuid+"."+extension;
				
				File destFile=new File (uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
				
				// 파일 객체를 통해서 파일을 저장
				partFile.transferTo(destFile);
				
				//테이블이 첨부파일 정보 저장
				BoardFileDto boardFileDto=new BoardFileDto();
				boardFileDto.setBoardId(boardId);
				boardFileDto.setFileName(fileName);
				boardFileDto.setFileSize(partFile.getSize());
				boardFileDto.setFileContentType(partFile.getContentType());
				boardFileDto.setFileUrl(uploadFolder + "/" + savingFileName);
				
				dao.boardFileInsert(boardFileDto);
			}
			boardResultDto.setResult(SUCCESS);
			
		} catch(Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		
		return boardResultDto;
	}
	
}
