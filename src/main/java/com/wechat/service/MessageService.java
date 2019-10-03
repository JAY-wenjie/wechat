package com.wechat.service;

import org.jdom2.Element;

import javax.servlet.http.HttpSession;

public interface MessageService{

String messageFactory(Element element, HttpSession session);
}
