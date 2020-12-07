class ResistorColor {
  static final Map<String, int> resistor_Color = {
    "black": 0,
    "brown": 1,
    "red": 2,
    "orange": 3,
    "yellow": 4,
    "green": 5,
    "blue": 6,
    "violet": 7,
    "grey": 8,
    "white": 9,
  };

  List<String> get colors => resistor_Color.keys.toList();

  int colorCode(String color) {
    return colors.indexOf(color);
    // or resistor_Color[color]
  }
}
