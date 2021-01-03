package com.heraizen.shoppingservlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.heraizen.DTO.BookList;
@WebServlet("/cartBook")
public class CartBookServlet extends HttpServlet {

	
	int check=0, k=0 ,total;
	public void service(HttpServletRequest req,HttpServletResponse res ) throws ServletException, IOException
	{
		ShoppingCardImplement shop = ShoppingCardImplement.getInstance();
		String bookId =(String) req.getParameter("cartbook");
		
		if(bookId!=null)
		{
			
		
		HttpSession session = req.getSession();
		
		Object object = session.getAttribute("cartItem");
		
		Object setobject = session.getAttribute("setcartItem");
		
		
		
		
		BookList book = shop.getbooklist(bookId);
		
		
		
		if(object == null)
		{
			List<BookList> books = new ArrayList<BookList>();
			books.add(book);
			session.setAttribute("cartItem", books);
			session.setAttribute("total", totalprice(books));
		}
		else {
			List<BookList> books = (List<BookList>) object;
			
			if(!isduplicate(books,book.getid()))
			{
				books.add(book);
				session.setAttribute("cartItem", books);
			}
			else
			{
				
				books = increment(books,book.getid());
			

				
			}
			System.out.println("$$$"+books);
			
			for(BookList b : books)
			{
				System.out.println(b.getid()+" "+b.getDuplicate());
			}
			
			session.setAttribute("cartItem", books);
			session.setAttribute("total", totalprice(books));
		}
		}
		RequestDispatcher rd = req.getRequestDispatcher("/viewcarft.jsp");
		rd.forward(req, res);
		
	}
	
	
	public boolean isduplicate(List<BookList> setbook , String id)
	{
		check = 0;
		setbook.forEach(e->{
		
		if(e.getid().equalsIgnoreCase(id))
		{
		check=1;
		}
		
		});
		
		if(check==0)
		{
			System.out.println("new");
			return false;
		}
		else
		{
			
			
			
			
			return true;
		}
		
		
		
	}
	
	public int totalprice(List<BookList> setbook)
	{
		total=0;
		
		setbook.forEach(e->{
			
			total = total+(e.getDuplicate()*e.getPrice());
		});
		return total;
	}
	
	public List<BookList> increment(List<BookList> setbook , String id)
	{
		setbook.forEach(e->{
			
			if(e.getid().equalsIgnoreCase(id))
			{
			e.setDuplicate(e.getDuplicate()+1);
			}
			
			});
		
		
		return setbook;
	}
}
