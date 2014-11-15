import cmdUtil.activate;
import cmdUtil.admin;
import cmdUtil.display;



public class DivRootOne {

	public String[] splitsource(String $cmdIn){
		String[] $result = $cmdIn.split(" ");
		return $result;
	}


	public String process(String[] $split){
		String $result = null;
		activate act = new activate();
		display dis = new display();
		admin adm = new admin();
		String $firstword = $split[0];
		String $secondword = $split[1];
		String $thirdword = $split[2];
		String $fourthword = $split[3];
		if($firstword.equals("activate")){
			if($secondword.equals("protocol:dataStorage")){
				act.activateDatastorage();
			}else if($secondword.equals("protocol:bankRet")){
				act.bankRet();
			}
		}else if($firstword.equals("Display")){
			if($secondword.equals("protocol:dataBanklog")){
				dis.retDataBanklog();
			}
		}else if($firstword.equals("admins")){
			if($secondword.equals("protocol:displayAdmins")){
				adm.displayAdmins();
			}else if($secondword.equals("protocol:deleteAdmin")){
				adm.deleteAdmin($thirdword); 
			}else if($secondword.equals("protocol:addAdmin")){
				adm.addAdmin($thirdword, $fourthword);
			}else if($secondword.equals("protocol:getAdmin")){
				adm.getAdmin($thirdword);
			}
		}
		return $result;
	}


	
}
