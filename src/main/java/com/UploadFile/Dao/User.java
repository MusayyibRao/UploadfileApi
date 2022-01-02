package com.UploadFile.Dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.GenerationType;
@Entity
@Table(name="file1")
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String docName;
public User(String docName, String docType, byte[] data) {
	super();
	this.docName = docName;
	this.docType = docType;
	this.data = data;
}


public String getDocName() {
	return docName;
}


public void setDocName(String docName) {
	this.docName = docName;
}


private String docType;


@Lob
private byte[] data;


public User() {
	
}


public int getId() {
	return id;
}


public void setId(int id) {
	this.id = id;
}


public String getDocType() {
	return docType;
}


public void setDocType(String docType) {
	this.docType = docType;
}


public byte[] getData() {
	return data;
}


public void setData(byte[] data) {
	this.data = data;
}


public User(String docType, byte[] data) {
	super();
	this.docType = docType;
	this.data = data;
}
 




}
