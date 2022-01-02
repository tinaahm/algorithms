import org.pg4200.les11.BitReader;
import org.pg4200.les11.BitWriter;

import java.util.Locale;

public class Ex05 {

	public static byte[] compress(String chessMoves) {
		String[] movesArray = chessMoves.split("\\n");
		BitWriter writer = new BitWriter();

		for (int i = 0; i < movesArray.length; i++) {
			writer.write(Integer.parseInt(String.valueOf(movesArray[i].charAt(0))));
			i++;
			if (movesArray[i].equalsIgnoreCase("knight")) {
				writer.write('k');
			} else if (movesArray[i].equalsIgnoreCase("king")) {
				writer.write('K');
			} else {
				writer.write(movesArray[i].toLowerCase(Locale.ROOT).charAt(0));
			}
			i += 2;
			writer.write(movesArray[i].charAt(0));
			writer.write(Integer.parseInt(String.valueOf(movesArray[i].charAt(1))));
			i += 2;
			writer.write(movesArray[i].charAt(0));
			writer.write(Integer.parseInt(String.valueOf(movesArray[i].charAt(1))));
			if (movesArray[i].charAt(2) == '!') {
				writer.write('!');
			}
		}

		return writer.extract();
	}

}