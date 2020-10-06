package com.qlu.web.controller;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateVerify
 */
@WebServlet("/createVerify")
public class CreateVerify extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BufferedImage img = new BufferedImage(200, 40, BufferedImage.TYPE_INT_BGR);
		Graphics2D g = (Graphics2D) img.getGraphics();
		g.setColor(new Color(0XFFF4C1));
		g.fillRect(0, 0, 200, 40);
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789赵钱孙李!~=-()$%^#@".toCharArray();
		g.setStroke(new BasicStroke(5.0F));
		g.setColor(Color.BLACK);
		g.setFont(new Font("Fixedsys", Font.BOLD, 24));
		Random ran = new Random();
		int len = chars.length;
		HttpSession session = request.getSession();
		String verify = "";
		for (int i = 0; i < 4; i++) {
			char c = chars[ran.nextInt(len)];
			g.drawString(c+"", 20+50*i, 25);
			verify = verify + (c+"");
		}
		session.setAttribute("verify", verify);
		ImageIO.write(img, "jpg", response.getOutputStream());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
