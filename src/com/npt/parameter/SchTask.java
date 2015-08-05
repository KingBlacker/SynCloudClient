package com.npt.parameter;
/**
 * example:
 * schtasks  /create
 * 			 /tn "RsyncSchedule"
 * 			 /tr "rsync -av rsync://192.168.0.118:873/doc /cygdrive/c/users/matrix/desktop/sync"
 * 			 /sc daily
 * 			 /st 15:45
 * 			 /ru matrix
 * 			 /rp 121550
  * @author matrix
 *
 */
public class SchTask {
	/**
	 * schedule task name
	 */
	private String schName;
	private String schCmd;
	private String interval;
	private String starTime;
	private String username;
	private String userpwd;
	
	public SchTask(String schName,String schCmd,String interval,String starTime,String username,String userpwd){
			this.schName = schName;
			this.schCmd = schCmd;
			this.interval = interval;
			this.starTime = starTime;
			this.username = username;
			this.userpwd = userpwd;
	}
	
	/**
	 * create a task schedule
	 * @return String cmd
	 */
	public String createSch(){
		String cmd = "schtasks /create"
					  +" /tn \"" + this.schName
					  +"\" /tr \"" + this.schCmd
					  +"\" /sc " + this.interval
					  +" /st " + this.starTime
					  +" /ru " + this.username
					  +" /rp " + this.userpwd;
		return cmd;
		
	}
	/**
	 * delete a task schedule
	 * @return
	 */
	public String deleteSch(){
		String cmd = null;
		//TODO
		return cmd;
	}
	/**
	 * query all the schedule
	 * @return
	 */
	public String querySch(){
		String cmd = null;
		//TODO
		return cmd;
	}
	/**
	 * change the schedule
	 * @return
	 */
	public String changeSch(){
		String cmd = null;
		//TODO
		return cmd;
	}
	/**
	 * run the schedule according to the needs
	 * @return
	 */
	public String runSch(){
		String cmd = null;
		//TODO
		return cmd;
	}
	/**
	 * end the schedule
	 * @return
	 */
	public String endSch(){
		String cmd = null;
		//TODO
		return cmd;
	}
	/**
	 * display the cmd string
	 * @param str
	 */
	public void display(String str){
		System.out.println("---------\n"
								+str+
							"\n---------\n");
	}


}
