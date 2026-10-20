package poke;

public class Entry {
	double typechart[][] = new double[5][5];
	String type[] = new String[5]; // 0一般，1火，2水,3電系，4草

	public Entry() {
		type[0] = "一般";
		type[1] = "火";
		type[2] = "水";
		type[3] = "電";
		type[4] = "草";

		typechart[0][0] = 1.0;
		typechart[0][1] = 1.0;
		typechart[0][2] = 1.0;
		typechart[0][3] = 1.0;
		typechart[0][4] = 1.0;

		typechart[1][0] = 1.0;
		typechart[1][1] = 0.5;
		typechart[1][2] = 0.5;
		typechart[1][3] = 1.0;
		typechart[1][4] = 2.0;

		typechart[2][0] = 1.0;
		typechart[2][1] = 2.0;
		typechart[2][2] = 0.5;
		typechart[2][3] = 1.0;
		typechart[2][4] = 0.5;

		typechart[3][0] = 1.0;
		typechart[3][1] = 1.0;
		typechart[3][2] = 2.0;
		typechart[3][3] = 0.5;
		typechart[3][4] = 0.5;

		typechart[4][0] = 1.0;
		typechart[4][1] = 0.5;
		typechart[4][2] = 2.0;
		typechart[4][3] = 1.0;
		typechart[4][4] = 0.5;
	}

	int checktype(String s) {
		int k = -1;
		for (int i = 0; i < type.length; i++) {
			if (type[i].compareTo(s) == 0) {
				k = i;
				break;
			}
		}
		return k;
	}

	double c_table(int att, int def) {
		return typechart[att][def];
	}
}
