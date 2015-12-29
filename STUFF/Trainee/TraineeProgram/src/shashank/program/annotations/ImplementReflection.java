package shashank.program.annotations;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;


public class ImplementReflection {
	

	public static void main(String args[]){
		String msg = null;
		String path = null;

		
			Class<TestAnnotation> cl = TestAnnotation.class;
			
			try {
				Method method = cl.getDeclaredMethod("write");
				WriteInFile writeinfile = method.getAnnotation(WriteInFile.class);
				msg=writeinfile.message();
				path=writeinfile.location();
			} catch (NoSuchMethodException e) {
			
				e.printStackTrace();
			} catch (SecurityException e) {
			
				e.printStackTrace();
			}
			
		File file = new File(path);

		
	
		FileWriter fw = null;
		try {
			fw = new FileWriter(file.getAbsoluteFile());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		BufferedWriter bw = new BufferedWriter(fw);
		try {
			bw.write(msg);
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		try {
			bw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}

		System.out.println("Done");

	}
}
