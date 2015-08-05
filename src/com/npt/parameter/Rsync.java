package com.npt.parameter;

/**
 *use rsync cmd to make the synchronic files
 *cmd: rsync  -av rsync://192.168.0.124:873/doc  /cygdrive/c/sync
 *
 **/

public class Rsync {
	
	private String ip;
	private String port;
	private String moduleName;
	
	/**
	 * src:the module in the server
	 * dst:the module in the local machine
	 */
	private String dstPath;
	
	public Rsync(String ip,String port,String moduleName,String dstPath){
	       this.ip = ip;
	       this.port = port;
	       this.moduleName = moduleName;
	       this.dstPath = dstPath;
	}
	
	/**
	 * concat the string of the command
	 * @return
	 */
	public String getCmd(){

		String cmd = "rsync -av rsync://"+this.ip+":"+this.port+"/"+this.moduleName+"	/cygdrive/"+this.dstPath;
		return cmd;
	}
	
	/**
	 * change the parameter of the rsync task schedule
	 * @return
	 */
	public String chgCmd(){
		String cmd = null;
		//TODO
		return cmd;
	}
	
	/**
	 * display the string 
	 * @param str
	 */
	public void display(String str){
		System.out.println("---------\n"+str+"\n---------\n");
	}
	
	
}
