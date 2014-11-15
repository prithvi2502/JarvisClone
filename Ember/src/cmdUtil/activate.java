package cmdUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class activate {


	public int cmdcode(String $cmdName) {
		int $resultfinal = -1;
		if($cmdName.equals("protocol:Storage")){
			$resultfinal = 0;
			//activates data storage so that data can be stored in a data structure of some sort.
		}else if($cmdName.equals("protocol:firstStageReport")){
			$resultfinal = 1;
			//shows a log of all of the first stage process that happened in the response algorithm.
		}else if($cmdName.equals("protocol:dispTables")){
			$resultfinal = 2;
		}else if($cmdName.substring(0,19).equals("protocol:insertData")){
			$resultfinal = 3;
		}
		return $resultfinal;
	}

	public String cmdName(int $cmdCode, String $cmdName) throws ClassNotFoundException, SQLException {
		String answer = null;
		
		switch($cmdCode){
		case 0:
			answer = null;
		case 1:
			answer = null;
		case 2:
			answer = display.retDataTableNomen();
		case 3:
			String[] splitArray = $cmdName.split("\\s+");
			int tableBigIndex = 0;
			int tableEndIndex = 0;
			int colmBigIndex = 0;
			int colmEndIndex = 0;
			int valBigIndex = 0;
			int valEndIndex = 0;
			String tableName = null;
			ArrayList<String> columnNames = new ArrayList<String>();
			ArrayList<String> values = new ArrayList<String>();
			for(int i = 0; i < splitArray.length; i++) {
				if(splitArray[i] == "T[") {
					tableBigIndex = i;
				} else if(splitArray[i] == "]T") {
					tableEndIndex = i;
				} else if(splitArray[i] == "C[") {
					colmBigIndex = i;
				} else if(splitArray[i] == "]C") {
					colmEndIndex = i;
				} else if(splitArray[i] == "V[") {
					valBigIndex = i;
				} else if(splitArray[i] == "]V") {
					valEndIndex = i;
				}
			}
			
			for(int i = tableBigIndex; i < tableEndIndex; i++) {
				if(splitArray[i] != "T[" || splitArray[i] != "]T" || splitArray[i] != " ") {
					tableName = splitArray[i];
				}
			}
			for(int i = colmBigIndex; i < colmEndIndex; i++) {
				if(splitArray[i] != "C[" || splitArray[i] != "]C" || splitArray[i] != " ") {
					columnNames.add(splitArray[i]);
				}
			}
			for(int i = valBigIndex; i < valEndIndex; i++) {
				if(splitArray[i] != "V[" || splitArray[i] != "]V" || splitArray[i] != " ") {
					values.add(splitArray[i]);
				}
			}

			System.out.println(tableName);
			for(int i = 0; i < columnNames.size(); i++) {
				System.out.println(i + " " + columnNames.get(i));
			}
			for(int i = 0; i < values.size(); i++) {
				System.out.println(i + " " + values.get(i));
			}
			
			String ultimate = null;
			for (String a: columnNames) {
				ultimate = ultimate + " " + a;
			}
			for (String a: values) {
				ultimate = ultimate + " " + a;
			}
			ultimate = ultimate + " " + tableName;
			databaseAdmin DA = new databaseAdmin();
			answer = ultimate;
			//answer = DA.insertData(tableName, columnNames, values);
		}
		
		return answer;
	}

	public String cmdClass() {
		// TODO Auto-generated method stub
		return null;
	}


	public void bankRet() {
		// TODO Auto-generated method stub
	}

	public void activateDatastorage() {
		// TODO Auto-generated method stub
		
	}

	



}
