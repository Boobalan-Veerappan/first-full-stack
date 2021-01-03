package com.heraizen.shoppingservlet;

import static com.mongodb.client.model.Accumulators.push;
import static com.mongodb.client.model.Aggregates.group;
import static com.mongodb.client.model.Aggregates.project;
import static com.mongodb.client.model.Aggregates.unwind;
import static com.mongodb.client.model.Projections.excludeId;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import static com.mongodb.client.model.Projections.computed;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Projections.fields;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.bson.BsonNull;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.heraizen.DTO.*;
//import com.heraizen.cj.ipl.Dto.PlayerDTO;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	MongoDatabase database;
	MongoDatabase Userdatabase;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		
		ShoppingCardImplement shopimp = ShoppingCardImplement.getInstance();
		
		CodecRegistry pojor = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
				fromProviders(PojoCodecProvider.builder().automatic(true).build()));
		MongoClientSettings settings = MongoClientSettings.builder().codecRegistry(pojor)
				.applyConnectionString(new ConnectionString(
						"mongodb+srv://boobalan:boobalan@cluster0.tjflf.mongodb.net/<dbname>?retryWrites=true&w=majority"))
				.build();
		com.mongodb.client.MongoClient client = MongoClients.create(settings);
		
		database = client.getDatabase("userDetails");
		Userdatabase = client.getDatabase("userDetails");
		
		MongoCollection<UserDetails> Usercollection = Userdatabase.getCollection("products", UserDetails.class);
		AggregateIterable<UserDetails> userresult = Usercollection.aggregate(Arrays.asList(project(fields(excludeId(), computed("UserName", "$UserName"), computed("Password", "$Password")))));
		HttpSession session = req.getSession();
		String UserName= (String) session.getAttribute("username");
		String Password= (String) session.getAttribute("pasword");
		System.out.println(UserName+"  "+Password);
		if(UserName == null && Password ==null)
		{
			UserName=req.getParameter("UserName");
			 Password = req.getParameter("password");
			 System.out.println("#####"+UserName+"  "+Password);
		}
		
		int m=0;
		
	for(UserDetails user : userresult)
	{
		System.out.println("$$$$$$"+user.getUserName()+"  "+Password);
		if(UserName.equalsIgnoreCase(user.getUserName()) && Password.equalsIgnoreCase(user.getPassword()))
		{
			m=1;
			MongoCollection<BookList> BookListcollection  = Userdatabase.getCollection("BookList", BookList.class);
			AggregateIterable<BookList> BookListresult = shopimp.booksList();	
					
			List<BookList> books=new ArrayList<BookList>();
			
			
			for(BookList book : BookListresult)
			{
				String tite = book.getTitle();
				books.add(new BookList(book.getTitle(),book.getAuthor(),book.getPublisher(),book.getid()));
			}
			
			
			for(BookList book : BookListresult)
			{
				System.out.println(book.getid()+book.getPrice());
			}
			
for(BookList book : books)
{
	System.out.println("$#@#$@#$@#$@#@# "+book.ids);
}

if(m==1)
{
	session.setAttribute("username", UserName);
	session.setAttribute("pasword", Password);
}
			req.setAttribute("name", books);
			RequestDispatcher rd = req.getRequestDispatcher("/view.jsp");
			rd.forward(req, res);
		}
		
	}
	
	
//		
		if(m==0)
		{
			RequestDispatcher rd = req.getRequestDispatcher("/invalidpage.jsp");
			rd.forward(req, res);
		}
		
	}
	
}
