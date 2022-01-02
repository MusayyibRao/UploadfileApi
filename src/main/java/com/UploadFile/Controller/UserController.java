package com.UploadFile.Controller;

import java.net.http.HttpHeaders;
import java.util.List;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.UploadFile.Dao.User;
import com.UploadFile.Service.UserService;

@Controller
public class UserController {

@Autowired
private UserService userservice;


@GetMapping("/users")
public String get(Model model)
{
List<User> user= userservice.getFiles();
model.addAttribute("user",user);
return "user";
	
}

@PostMapping("/uploadFiles")
public String uplaodMultipleFile(@RequestParam("files") MultipartFile[] files)
{
for(MultipartFile file:files) {
userservice.saveFile(file);	
}
   return "redirect:/";
}	


  @GetMapping("/downloadFile/{fileId}") public ResponseEntity<ByteArrayResource>
  downloadFile(@PathVariable Integer fileId){ User
  user=userservice.getfile(fileId).get(); return
  ResponseEntity.ok().contentType(MediaType.parseMediaType(user.getDocType())).header(org.springframework.http.HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + user.getDocName() + "\"").body(new ByteArrayResource(user.getData()));
  
  }
 
}