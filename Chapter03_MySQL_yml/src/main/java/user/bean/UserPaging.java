package user.bean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserPaging {
	private int currentPage; // 현재페이지
	private int pageBlock; //[이전][1][2][3][다음] 
	private int pageSize; // 1페이지당 5개씩
	private int totalA; // 총글수
	private StringBuffer pagingHTML; // null값 가지고 있음.
		
	public void makePagingHTML() {
		pagingHTML = new StringBuffer();
		
		
	//	int totalP = (totalA-1) / pageSize + 1; // 총 페이지수 / 5는 현재 뿌려야할 pageSize로 넘어와야함
		int totalP = (totalA + pageSize-1) / pageSize; // 총 페이지수 / 5는 현재 뿌려야할 pageSize로 넘어와야함
		
		int startPage = (currentPage -1 ) / pageBlock * pageBlock + 1; // 시작 페이지 번호
		int endPage = startPage + pageBlock -1;
		
		if (endPage > totalP) endPage = totalP;
		
		if (startPage != 1)
//			if (startPage > pageBlock)
			pagingHTML.append("[ <span id = 'paging' onclick = 'userPaging(" + (startPage-1) + ")'>이전</span>]"); 
		
		for (int i=startPage; i<=endPage; i++) {
			if (i==currentPage) 
				pagingHTML.append("[ <span id = 'currentPaging' onclick = 'userPaging(" + i + ")'>" + i + "</span>]");
			else 
				pagingHTML.append("[ <span id = 'paging' onclick = 'userPaging(" + i + ")'>" + i + "</span>]");
		}
		if (endPage < totalP)
			pagingHTML.append("[ <span id = 'paging' onclick = 'userPaging(" + (endPage+1) + ")'>다음</span>]"); 
		
	}
}
