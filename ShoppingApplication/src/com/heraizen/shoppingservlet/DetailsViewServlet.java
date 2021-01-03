package com.heraizen.shoppingservlet;

import static com.mongodb.client.model.Aggregates.project;
import static com.mongodb.client.model.Projections.excludeId;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.heraizen.DTO.BookList;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
@WebServlet("/cart")
public class DetailsViewServlet extends HttpServlet {
	MongoDatabase Userdatabase;
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		ShoppingCardImplement shopimp = ShoppingCardImplement.getInstance();
		
		String mobile = req.getParameter("submit");
//		CodecRegistry pojor = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
//				fromProviders(PojoCodecProvider.builder().automatic(true).build()));
//		MongoClientSettings settings = MongoClientSettings.builder().codecRegistry(pojor)
//				.applyConnectionString(new ConnectionString(
//						"mongodb+srv://boobalan:boobalan@cluster0.tjflf.mongodb.net/<dbname>?retryWrites=true&w=majority"))
//				.build();
//		com.mongodb.client.MongoClient client = MongoClients.create(settings);
//		
//		Userdatabase = client.getDatabase("userDetails");
//		MongoCollection<BookList> BookListcollection  = Userdatabase.getCollection("BookList", BookList.class);
		
		
		AggregateIterable<BookList> BookListresult =shopimp.booksList();
		
		BookList bk = null;
		for(BookList book : BookListresult)
		{
			if(book.getTitle().equalsIgnoreCase(mobile))
			{
				
				bk = book;
			}
			
		}
		
		req.setAttribute("book",bk);
		RequestDispatcher rd = req.getRequestDispatcher("/BookDetails.jsp");
		rd.forward(req, res);
	}
	
}
