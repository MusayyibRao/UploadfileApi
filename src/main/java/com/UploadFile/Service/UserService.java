package com.UploadFile.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.UploadFile.Dao.User;
import com.UploadFile.Repository.UserRepository;

@Service
public class UserService {


@Autowired
private UserRepository userrepo;

public User saveFile(MultipartFile file)
{
	
String docname= file.getOriginalFilename();
try {
	User user= new User(docname,file.getContentType(),file.getBytes());
	return userrepo.save(user);
	}

catch(Exception e)
{
	}
return null;
}


public Optional<User> getfile(Integer fileId)
{
return userrepo.findById(fileId);	
}

public List<User> getFiles()
{
	return userrepo.findAll();
	
}
}
