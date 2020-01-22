package com.api.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReadWriteInFile {
	
	public static void writeResponseInFile(String data, String scenarioName) {
        File file = new File(System.getProperty("user.dir")+"/output_response/"+scenarioName+"_Response.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	
	public static String readRequestFromFileFiles(String fileName) {
		try {
			return new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/input_request/"+fileName)));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}


}
