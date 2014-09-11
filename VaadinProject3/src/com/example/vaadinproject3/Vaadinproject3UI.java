package com.example.vaadinproject3;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("vaadinproject3")
public class Vaadinproject3UI extends UI {

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Vaadinproject3UI.class)
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		CustomLayout layout = new CustomLayout("mylayout");
		setContent(layout);

		Label header = new Label("Custom layout");
		header.addStyleName("header");
		layout.addComponent(header, "header");
		
		Label menu = new Label("menu");
		layout.addComponent(menu, "menu");
		
		Label content = new Label("This is content of page.");
		layout.addComponent(content, "content");		
		
		Label footer = new Label("Created by Vaadin, 2013");
		layout.addComponent(footer, "footer");	
	}

}