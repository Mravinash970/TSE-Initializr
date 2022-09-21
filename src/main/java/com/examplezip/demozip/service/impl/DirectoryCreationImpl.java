package com.examplezip.demozip.service.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examplezip.demozip.model.Details;


import com.examplezip.demozip.service.DirectoryCreation;
@Service
public class DirectoryCreationImpl implements DirectoryCreation {


	@Override
	public void create(Details detail) {


		String package_name = detail.getPackage_name();
		String project_name=detail.getArtifact();
		String[] pn = package_name.split("[.]");

		File parent = new File("c:/demo"+File.separator+project_name);
		parent.mkdirs();
		File sub_parent = new File(parent,"src");
		sub_parent.mkdirs();
		String path = "c:/demo/" + project_name + "/" + "src";
		//System.out.println("hi");
		String subs[] = {"main","test"};

		for (String sub : subs) {
			File subFile = new File(path, sub);
			subFile.mkdirs();

		}
		File subFile1 = new File("c:/demo/" + project_name + "/" + "src/main", "java");
		subFile1.mkdirs();
		subFile1 = new File("c:/demo/" + project_name + "/" + "src/main", "resources");
		subFile1.mkdirs();
		try {
			FileWriter myWriter = new FileWriter("C:\\demo\\"+project_name+"\\src\\main\\resources\\application.properties");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		subFile1 = new File("c:/demo/" + project_name + "/" + "src/test", "java");
		subFile1.mkdirs();

		String path2="c:/demo/" + project_name + "/" + "src/main/java";
		for(String s:pn) {
			File subFile = new File(path2, s);
			subFile.mkdirs();
			path2=path2+"/"+s;

		}
		String path3="c:/demo/" + project_name + "/" + "src/test/java";
		for(String s:pn) {
			File subFile = new File(path3, s);
			subFile.mkdirs();
			path3=path3+"/"+s;

		}

	}}