package user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(value="user")
public class UserController {
	//@Autowired
	//private UserService userService;
	
	@RequestMapping(value="writeForm", method=RequestMethod.GET)
	public ModelAndView write() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/writeForm");
		return mav;
	}
	/*
	@PostMapping(value="write")
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	
	@PostMapping(value="checkId")
	public String checkId(@RequestParam String id) {
		return userService.checkId(id);
	}
	
	@GetMapping(value="list")
	public ModelAndView list(@RequestParam(required = false, defaultValue = "1") String pg) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("pg", pg);
		mav.setViewName("/user/list");
		return mav;
	}
	
	@PostMapping(value="getUserList")
	public Map<String, Object> getUserList(@RequestParam(required = false, defaultValue = "1") String pg){
		return userService.getUserList(pg);
	}
	
	@GetMapping(value="updateForm")
	public ModelAndView updateForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/updateForm");
		return mav;
	}
	
	@PostMapping(value="getUser")
	public UserDTO getUser(@RequestParam String id){
		return userService.getUser(id);
	}
	
	@PostMapping(value="update")
	public void update(@RequestParam Map<String, String> map) {
		userService.update(map);
	}
	
	@GetMapping(value="deleteForm")
	public ModelAndView deleteForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/deleteForm");
		return mav;
	}
	
	@PostMapping(value="delete")
	public void delete(@RequestParam String id) {
		userService.delete(id);
	}
	
	@GetMapping(value="uploadForm")
	public ModelAndView uploadForm() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/uploadForm");
		return mav;
	}

//	@PostMapping(value="upload")
//	public void upload(@RequestParam MultipartFile img, HttpSession session) {		
//		//실제폴더
//		String filePath = session.getServletContext().getRealPath("/WEB-INF/storage");
//		System.out.println("실제폴더 = " + filePath);
//		String fileName = img.getOriginalFilename();
//		
//		File file = new File(filePath, fileName); //파일 생성
//		
//		try {
//			img.transferTo(file);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
//-----------------------------
	//name="img" 1개인 경우	
	/*
	@PostMapping(value="upload")
	public String upload(@RequestParam MultipartFile img, HttpSession session) {
		
		//가상폴더
		//String filePath = "D:/Spring Boot/workspace/Chapter03_MySQL_yml/src/main/webapp/WEB-INF/storage";
		//String fileName = img.getOriginalFilename();
		//
		//File file = new File(filePath, fileName); //파일 생성
		//
		//try {
		//	FileCopyUtils.copy(img.getInputStream(), new FileOutputStream(file)); //복사
		//
		//} catch (IOException e) {
		//	e.printStackTrace();
		//}
		
		//실제폴더
		String filePath = session.getServletContext().getRealPath("/WEB-INF/storage");
		System.out.println("실제폴더 = " + filePath);
		String fileName = img.getOriginalFilename();
		
		File file = new File(filePath, fileName); //파일 생성
		
		try {
			img.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//UserService -> UserDAO -> DB에는 이미지를 저장하는 것이 아니라 파일명만 저장
		
		return "<img src='../storage/" + fileName+ "' width='200' height='200'>";	
	}
	*/

	//name="img" 2개 이상인 경우, 배열로 받아온다.
	
}


































