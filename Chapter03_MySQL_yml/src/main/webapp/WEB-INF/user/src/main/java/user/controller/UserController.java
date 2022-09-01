package user.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import user.bean.UserDTO;
import user.service.UserService;

@RestController
@RequestMapping(value="user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="writeForm", method=RequestMethod.GET)
	public ModelAndView write() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/writeForm");
		return mav;
	}
	
	@PostMapping(value="write")
	public void write(@ModelAttribute UserDTO userDTO) {
		userService.write(userDTO);
	}
	
	@PostMapping(value="checkId")
	public String checkId(@RequestParam String id) {
		return userService.checkId(id);
	}
	
	@GetMapping(value="list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/list");
		return mav;
	}
	
	@PostMapping(value="getUserList")
	public List<UserDTO> getUserList(){
		return userService.getUserList();
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

	@PostMapping(value="upload")
	public void upload(@RequestParam MultipartFile img, HttpSession session) {		
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
	}	
}

































