package com.heraizen.gift;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.heraizen.gift.domain.X_masDetails;
import com.heraizen.gift.utilReader.utilReader;

@Component
public class Santaimpl {

	List<X_masDetails> data = new ArrayList<>();
	Map<String,X_masDetails> collect = new HashMap<>();
	
	Santaimpl() throws Exception
	{
		data = utilReader.loaderclass();
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

