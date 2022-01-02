/*
import org.pg4200.les11.BitReader;

public class draft5 {

	public static String decompress(byte[] data) {
		BitReader reader = new BitReader(data);
		String result = "";
		char c;

		while (data == null) {
			result += reader.readInt() + ".";
			c = reader.readChar();
			if (c == 'p') {
				result += " Pawn";
			} else if (c == 'k') {
				result += " Knight";
			} else if (c == 'K') {
				result += " King";
			} else if (c == 'q') {
				result += " Queen";
			} else if (c == 'b') {
				result += " Bishop";
			} else if (c == 'r') {
				result += " Rook";
			}
			result += " from ";
			result += reader.readChar();
			result += reader.readInt();
			result += " to ";
			result +=
		}
	}


	import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;

import java.util.Locale;

public class Ex05 {

	public static byte[] compress(String chessMoves) {
		String[] movesArray = chessMoves.split("\\n");
		BitWriter writer = new BitWriter();
		String str = "";

		for (int i = 0; i < movesArray.length; i++) {
			writer.write(Integer.parseInt(String.valueOf(movesArray[i].charAt(0))));
			//str += movesArray[i].charAt(0);
			i++;
			if (movesArray[i].equalsIgnoreCase("knight")) {
				//str += "k";
				writer.write('k');
			} else if (movesArray[i].equalsIgnoreCase("king")) {
				//str += "K";
				writer.write('K');
			} else {
				//str += movesArray[i].toLowerCase(Locale.ROOT).charAt(0);
				writer.write(movesArray[i].toLowerCase(Locale.ROOT).charAt(0));
			}
			i += 2;
			//str += movesArray[i];
			writer.write(movesArray[i].charAt(0));
			writer.write(Integer.parseInt(String.valueOf(movesArray[i].charAt(1))));
			i += 2;
			writer.write(movesArray[i].charAt(0));
			writer.write(Integer.parseInt(String.valueOf(movesArray[i].charAt(1))));
			if (movesArray[i].charAt(2) == '!') {
				writer.write('!');
			}
			/*else {str += movesArray[i].substring(0, 1);}
			writer.write(str);
			str = "";*/
		/*}

				return writer.extract();
				}

				}

}*/