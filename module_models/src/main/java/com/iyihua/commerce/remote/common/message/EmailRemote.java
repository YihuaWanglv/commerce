package com.iyihua.commerce.remote.common.message;


import com.iyihua.commerce.model.component.message.EmailMessage;

public interface EmailRemote {

	public void send(EmailMessage message);
}
