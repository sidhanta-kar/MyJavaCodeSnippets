/**
 * 
 */
package com.sidco.snippet.email.bean;

import java.io.File;
import java.util.ArrayList;

/**
 * @author Sidhanta Kumar Kar
 *
 */
public class Mail {

	public Mail() {
		super();
		this.useTls = false;
		this.port = 25;
		this.host = "IN-HYD-DAGND1.corp.capgemini.com";
		this.from = "sidhanta.kar@capgemini.com";
		this.pass = "India123";
		this.subject = "New Subject";
		this.body = "Empty Message";
		this.attachments = null;
	}

	public Mail(String[] to, String[] cc, String[] bcc, boolean useTls,
			String host, int port, String from, String pass, String subject,
			String body, ArrayList<File> attachments) {
		super();
		this.to = to;
		this.cc = cc;
		this.bcc = bcc;
		this.useTls = useTls;
		this.host = host;
		this.port = port;
		this.from = from;
		this.pass = pass;
		this.subject = subject;
		this.body = body;
		this.attachments = attachments;
	}

	public String[] getTo() {
		return to;
	}

	public void setTo(String[] to) {
		this.to = to;
	}

	public String[] getCc() {
		return cc;
	}

	public void setCc(String[] cc) {
		this.cc = cc;
	}

	public String[] getBcc() {
		return bcc;
	}

	public void setBcc(String[] bcc) {
		this.bcc = bcc;
	}

	public boolean isUseTls() {
		return useTls;
	}

	public void setUseTls(boolean useTls) {
		this.useTls = useTls;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public ArrayList<File> getAttachments() {
		return attachments;
	}

	public void setAttachments(ArrayList<File> attachments) {
		this.attachments = attachments;
	}

	// Variable declaration start
	private String[] to = {"sidhanta.kar@capgemini.com"};
	private String[] cc = {"sidhanta.kar@capgemini.com"};
	private String[] bcc = {"sidhanta.kar@capgemini.com"};
	private boolean useTls;
    private String host;
	private int port;
	private String from;
	private String pass;
	private String subject;
	private String body;
	private ArrayList<File> attachments;
	// Variable declaration end

}

