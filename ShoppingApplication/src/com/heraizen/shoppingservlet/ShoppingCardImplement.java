package com.heraizen.shoppingservlet;

import static com.mongodb.client.model.Aggregates.project;
import static com.mongodb.client.model.Projections.computed;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.util.Arrays;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.heraizen.DTO.BookList;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class ShoppingCardImplement implements ShoppingService {
	static ShoppingCardImplement shopcard = null;
	
	AggregateIterable<BookList> BookListresult;
	ShoppingCardImplement()
	{
		System.out.println("check");
		
		CodecRegistry pojor = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		MongoClientSettings settings = MongoClientSettings.builder().codecRegistry(pojor)
				.applyConnectionString(new ConnectionString(
						"mongodb+srv://boobalan:boobalan@cluster0.tjflf.mongodb.net/<dbname>?retryWrites=true&w=majority"))
				.build();
		com.mongodb.client.MongoClient client = MongoClients.create(settings);
		MongoDatabase Userdatabase;
		Userdatabase = client.getDatabase("userDetails");
		MongoCollection<BookList> BookListcollection  = Userdatabase.getCollection("BookList", BookList.class);
		 BookListresult = BookListcollection.aggregate(Arrays.asList(project(fields(excludeId(), computed("ids", "$ids"), computed("title", "$title"), computed("subtitle", "$subtitle"), computed("author", "$author"), computed("publisher", "$publisher"), computed("pages", "$pages"), computed("description", "$description"), computed("image", "$image"), computed("price", "$price")))));
		
	}
	
	public static ShoppingCardImplement getInstance()
	{
		if(shopcard == null)
		{
			shopcard = new ShoppingCardImplement();
			
		}
		
		return shopcard;
	}
	
	@Override
	public BookList getbooklist(String id) {
		
		System.out.println("all app "+BookListresult);
		for(BookList bk:BookListresult)
		{
			System.out.println("111"+bk);
		}
		
		
		BookList bkl=null;
	for(BookList book : BookListresult)
	{
		if(book.getid().equalsIgnoreCase(id))
		{
			bkl = book;
		}
	}
		
		return bkl;
	}
	
	public AggregateIterable<BookList> booksList()
	{
		return BookListresult;
	}
	
}
