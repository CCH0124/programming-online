class ResistorColorDuo {
  static final Map<String, String> resistor_Color = {
    "black": "0",
    "brown": "1",
    "red": "2",
    "orange": "3",
    "yellow": "4",
    "green": "5",
    "blue": "6",
    "violet": "7",
    "grey": "8",
    "white": "9",
  };
  
  int value(List<String> colorName) {
    String result = "";
    for (String item in colorName) {
      result += resistor_Color[item];
    }
    return int.parse(result);
  }
}

/**
 * other solve
 */

/**
class ResistorColorDuo {
  static final List<String> resistor_Color = [
    "black",
    "brown",
    "red",
    "orange",
    "yellow",
    "green",
    "blue",
    "violet",
    "grey",
    "white",
  ];
  
  int value(List<String> colorsName) {
    List<int> codes = colorsName.fold([], (a, b) => a..add(resistor_Color.indexOf(b)));
    return int.parse(codes.join());

    /// or
    int colorCode(String color) => resistor_Color.indexOf(color);
    int value(List<String> colorsName) => int.parse(colorsName.map(colorCode).join());
  }
} */
