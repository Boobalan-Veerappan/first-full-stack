package com.heraizen.christmasfriend.impl;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.heraizen.christmasfriend.domain.X_masDetails;
import com.heraizen.christmasfriend.utils.utilReader;
@Component
public class scantaimpelment {

	List<X_masDetails> data = new ArrayList<X_masDetails>();
	Map<String,X_masDetails> collect = new HashMap<>();
	
	
	public  void sceretScanta() throws Exception
	{
		
		 data = utilReader.loaderclass(); 
		Map<String,X_masDetails> giftDetils= secert_scanta(0,0);
		
		
		File file = new File(System.getProperty("java.io.tmpdir")+"/upload/"+"text.txt");
		if(file.createNewFile())
		{
			System.out.println("Create File");
		}
		else
		{
			System.out.println("alreay");
		}
		
		
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
	Map<String,X_masDetails> secert_scanta(int n,int m)
	{
		for(int i=n;i<data.size();i++)
		{
		for(int j=m;j<data.size();j++ )
		{
			
			
			if(!data.get(j).getName().equals(data.get(i).getName()))
			{
				
				if(!collect.containsValue(data.get(j)) && collect.size()!=data.size())
				{
					
					collect.put(data.get(i).getName(), data.get(j));
					
					secert_scanta(i,j);	
					
					
				}
				
				if(collect.size()==data.size())
				{
					
					return collect;
				}
				
				
				
			}
			
		}
		}
		return collect;
	}
	
}
