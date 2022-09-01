package user.controller;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import user.bean.UserDTO;
import user.service.UserService;

@RestController // 모든 문자열을 json으로 변환해서 넘김 / @Controller + @ResponseBody
@RequestMapping(value="user") // / 써도 되고 안써도 되고
public class UserController {
	
	@Autowired 
	private UserService userService; 
					//전에는UserService userService = new UserServiceImpl() 했었는데, 이제는 어노테이션 써주자!
	
	@RequestMapping(value = "writeForm", method = RequestMethod.GET)
		public ModelAndView write() {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("/user/writeForm");
			return mav;
	}
	
	@PostMapping(value = "write") // @RequestMapping(value="user") 이렇게 클래스 앞에 적어줘서 /user/write 이 부분을 -> write로 고쳤다
	public void write(@ModelAttribute UserDTO userDTO) {
		//DB
		userService.write(userDTO);
	}
	
	@PostMapping(value="checkId")
	public String checkId(@RequestParam String id) { // 아이디값 받아야지
		//DB
		return userService.checkId(id); // service가서 db 해결하자! 
	}
	
	@GetMapping(value = "list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/list");
		return mav;
	}
	
	@PostMapping(value="getUserList") // json으로 넘겨줘야함
	public List<UserDTO> getUserList() {
		//DB에서 레코드를 전부 꺼내온다.
		//select * from usertable
		//List(UserDTO) 리스트는 절대 return 될 수 없다 그래서 json썼다. 근데 스프링은 알아서 list->json 변환해준다.
		return  userService.getUserList(); //List를 리턴해서 보내면  스프링이 자동으로 바꾼다. 리스폰스바디가! 서비스로 가서 처리하자!
	}
	
	@GetMapping(value = "updateForm")
	public ModelAndView updateForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/updateForm");
		return mav;
	}
	@GetMapping(value = "uploadForm")
	public ModelAndView uploadForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/uploadForm");
		return mav;
	}
	
	@PostMapping(value="getUser")
	public UserDTO getUser(@RequestParam String id) {
		return userService.getUser(id);
	}
	@PostMapping(value = "update") 
	public void update(@RequestParam Map<String, String> map) {
		userService.update(map);
	}
	@GetMapping(value = "deleteForm")
	public ModelAndView deleteForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/deleteForm");
		return mav;
	}
	@PostMapping(value = "delete") 
	public void delete(@RequestParam String id) {
		userService.delete(id);
	}
//name="img" 1개인 경우

	/*
	@PostMapping(value = "upload") 
	@ResponseBody // 브라우저에 바로 뿌려버려랏
	//public String upload(@RequestParam MultipartFile img) { // MultipartFile 바로 서버에 올려버린다
		public String upload(@RequestParam MultipartFile img, HttpSession session) { //콜백 메소드  -> 스프링한테 세션 하나만 내놔 하고 말하면 세션값 준다.
		//가상폴더를 이용해서 올린다.
//		
//		String filePath = "C:\\spring\\workspace\\chapter06_SpringWebMaven\\WebContent\\storage";  // 임시저장소
//		String fileName = img.getOriginalFilename(); //임시파일 이름말고 너의 실제 이름을 가져다줘...
//		
//		File file = new File(filePath, fileName); //파일을 생성함.
//		// 현재 가지고 있는 파일을 복사하려고 한다.
//		try {
//			FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file)); // 내가만든 img 파일을 읽어서, 내가 만든 파일로 복사떠라
//			// img.transferTo(file); // 이동시켜라
//		
//		} catch (IOException e) {
//			e.printStackTrace();
//		} 
		
		
		//실제 폴더의 위치로 올라가겠다.
		String filePath = session.getServletContext().getRealPath("/storage"); // 실제 폴더의 위치를 가져다줌 / request나 session 둘다 가능
		//폴더는 만들어놔야 관리가 됨. 실제 폴더에는 즉각 들어가지만 , 가상 폴더에는 파일이 들어가지 않음.
		System.out.println("실제 폴더 = " + filePath); // 실제 폴더 위치를 알려줘
		String fileName = img.getOriginalFilename(); // 실제 이름을 알려줘
		
		File file = new File(filePath, fileName);  // 파일 생성
		
		try {
			img.transferTo(file);
		} catch (IOException e) { // 상속관계라서 부모만 남겨두면 자식 예외는 다 먹힘.
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		//UserService -> UserDAO(서비스에서 db로 간다.) -> db에는 이미지를 저장하는 것이 아니라 파일명만 저장
		
		return "<img src ='../storage/"+ fileName + "'width='200' height='200'>";
	}
	*/
//name="img" 2개 이상인 경우 , 배열로 받아온다.
	/*
	@PostMapping(value = "upload") 
	@ResponseBody // 브라우저에 바로 뿌려버려랏
	public void upload(@RequestParam MultipartFile[] img, HttpSession session) {
		//실제 폴더의 위치로 올라가겠다.
		String filePath = session.getServletContext().getRealPath("/storage"); // 실제 폴더의 위치를 가져다줌 / request나 session 둘다 가능
		String fileName;
		File file;
		
		if (img[0] != null) { // 0번째와 1번째의 두개의 파일을 선택할 수 있을때 1번째만 선택할 수 없다 -> 오류뜸
			fileName = img[0].getOriginalFilename(); 
			file = new File(filePath, fileName);
			
			try {
				img[0].transferTo(file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (img[1] != null) {
			fileName = img[1].getOriginalFilename(); // 시간을 붙이면 현재 시스템의 시간을 붙이기때문에 파일명이 계속 다르게 뜬다.
			file = new File(filePath, fileName);
			
			try {
				img[1].transferTo(file);
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	*/
	
	// 파일을 여러 개 선택 
	@PostMapping(value = "upload") 
	public void upload(@RequestParam("img[]")List<MultipartFile> list, HttpSession session) { // 절대 배열로 받으면 안된다. list로 받아야한다
		//실제 폴더에 올린다. 
		String filePath = session.getServletContext().getRealPath("/storage");
		String fileName;
		File file;
		
		for(MultipartFile img : list) {
			fileName = img.getOriginalFilename();
			file = new File(filePath, fileName);
			
			try {
				img.transferTo(file);
			}catch (IOException e) {
				e.printStackTrace();
			}
		}// for
	}
	
	@PostMapping(value = "getUserSearchList")
	public List<UserDTO> getUserSearchList (@RequestParam Map<String, String> map) {
		return userService.getUserSearchList(map);
	}
}
