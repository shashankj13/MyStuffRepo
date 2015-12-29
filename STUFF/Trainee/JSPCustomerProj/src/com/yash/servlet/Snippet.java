package com.yash.servlet;

public class Snippet {
	@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			System.out.println("Do get");
			//System.out.println(req.getMethod());
		}
}

