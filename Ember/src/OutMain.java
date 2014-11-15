import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.Scanner;

import cmdUtil.activate;
import learningUtil.Data;
import learningUtil.mainLearn;



public class OutMain {

	/**
	 * @param args
	 */
	public static boolean cmdProg = true;
	public static void main(String[] args) throws UnsupportedEncodingException, IOException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DivRootTwo $div2  = new DivRootTwo();
		@SuppressWarnings("resource")
		Scanner cmdPut = new Scanner(System.in);
		while(true){
			System.out.println("Options");
			System.out.println("");
			System.out.println("(1) CMD Drive");
			System.out.println("(2) Ember");
			System.out.println("(3) Sync Engine Util");
			mainLearn newData = new mainLearn();
			newData.dataStorage();
			int answer = cmdPut.nextInt();
			if(answer == 1){
				while(cmdProg){
					System.out.print("METADRIVE:/Ember:Protocol:2134/$");
					String cmdinput = cmdPut.nextLine();
					if(cmdinput.equals("protocol:exit")){
						break;
					}else{
						activate actCmd = new activate();
						int code = actCmd.cmdcode(cmdinput);
						String result = actCmd.cmdName(code, cmdinput);
						System.out.println(result);
					}
				}
			}else if(answer == 2){ 
				System.out.println("Hello my name is Ember, I will be your personal assistant.");
				System.out.println("I will learn and adapt to your lifestyle and respond to questions accordingly");
				while(cmdProg){
					@SuppressWarnings("resource")
					Scanner cmdPut2 = new Scanner(System.in);
					System.out.print("Enter your command here:");
					String cmdinput = cmdPut2.nextLine();
					if(cmdinput.equals("exit")){
						break;
					}else{
						String output = $div2.commonPhrs(cmdinput);
						
						if(output == null){
							String[] $splitSourceRes = $div2.splitsource(cmdinput);
							System.out.println($div2.process($splitSourceRes));
						}else{
							System.out.println(output);
						}
					}
				}
				
			}else if(answer == 3){
				System.out.println("Not available");
			}
		
		}
		
		
	}

}
