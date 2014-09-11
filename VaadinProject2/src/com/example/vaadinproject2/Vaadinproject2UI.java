package com.example.vaadinproject2;

import java.io.File;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.data.util.FilesystemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("vaadinproject2")
public class Vaadinproject2UI extends UI {
	 @WebServlet(value = "/*", asyncSupported = true, initParams = {
	            @WebInitParam(name = "ui", value = "com.example.MyUI"),
	            @WebInitParam(name = "productionMode", value = "false") })
	    public static class Servlet extends VaadinServlet {
	    }



	@Override
	protected void init(VaadinRequest request) {
		setContent(new AdjustableLayout());
	}

}