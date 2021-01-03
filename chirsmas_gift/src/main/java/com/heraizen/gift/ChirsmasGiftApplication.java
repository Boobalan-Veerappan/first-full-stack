package com.heraizen.gift;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


//import org.springframework.mail.javamail.JavaMailSender;
import com.heraizen.gift.domain.X_masDetails;
import com.heraizen.gift.utilReader.utilReader;

//import freemarker.template.Configuration;
//import freemarker.template.Template;
//import freemarker.template.TemplateException;

@SpringBootApplication
public class ChirsmasGiftApplication implements CommandLineRunner {


	
	@Autowired
	Santaimpl sant;
	
	
	List<X_masDetails> data = new ArrayList<>();
	Map<String,X_masDetails> collect = new HashMap<>();
	
	public static void main(String[] args) throws Exception {
		System.out.println(utilReader.loaderclass());
		Map<String, X_masDetails> reader = new HashMap<>();
		List<X_masDetails> data = utilReader.loaderclass();

		int i = 0;
		for (X_masDetails d : data) {
			int m = 0;

			while (m != 1) {

				int ran = ThreadLocalRandom.current().nextInt(0, data.size());

				if (ran != i) {

					if (!reader.containsValue(data.get(ran))) {
						m = 1;
						reader.put(d.getName(), data.get(ran));
					}

				}

			}

			i++;
		}
		
		reader.entrySet().forEach(e->{
			
			System.out.println(e.getKey() +"  "+e.getValue().getEmail());
			
		});
		

		SpringApplication.run(ChirsmasGiftApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		
		File file = new File("/home/spaneos/Videos/text.txt");
		if(file.createNewFile())
		{
			System.out.println("Create File");
		}
		else
		{
			System.out.println("alreay");
		}
		
		int a= 10;
		
		
		
		
		
		
		Map<String, Object> map = new HashMap<>();
		
		
		Map<String, X_masDetails> reader = new HashMap<>();
//		Template temp1 = config.getTemplate("greetingMail.ftl");
		 data = utilReader.loaderclass();

		int i = 0;
		for (X_masDetails d : data) {
			int m = 0;

			while (m != 1) {

				int ran = ThreadLocalRandom.current().nextInt(0, data.size());

				if (ran != i) {

					if (!reader.containsValue(data.get(ran))) {
						m = 1;
						reader.put(d.getName(), data.get(ran));
					}

				}

			}

			i++;
		}
		
		reader.entrySet().forEach(e->{
			
			Writer out = new OutputStreamWriter(System.out);
			StringWriter strwriter = new StringWriter();
			Map<String ,Object> obj =  new HashMap<>();
			//map.put(e.getKey(), e.)
			obj.put("details", e);
//			try {
//				temp1.process(obj, strwriter);
//			} catch (TemplateException | IOException e1) {
//				
//				e1.printStackTrace();
//			}
			System.out.println(strwriter);
			System.out.println("<________________________------------------------------------______________________________>");
			
		});
		
		
	Map<String,X_masDetails> giftDetils= sant.secert_scanta(0,0);	
		

	FileWriter writer = new FileWriter(file);
	giftDetils.entrySet().forEach(e->{
		
		System.out.println(e.getKey());
		System.out.println("<-------your Friend address------------>");
		System.out.println(e.getValue().getName());
		System.out.println(e.getValue().getAddress());
		System.out.println(e.getValue().getEmail());
		System.out.println("<------------------------------------------------->");
		
		System.out.println();
		System.out.println();
		
		try {
			writer.write("Hi  "+ e.getKey() +" Your Chrimas Friends  is "+e.getValue().getName()+" \n");
			writer.write("\n");
			writer.write("\n");
			
			writer.write("His Address \n "+e.getValue().getAddress()+" \n "+e.getValue().getEmail()+"\n");
			writer.write("\n -------------------------------------------------------------------------------\n");
		} catch (IOException e1) {
		
			e1.printStackTrace();
		}
		
		
	});
	writer.close();
	}
	
	

}
